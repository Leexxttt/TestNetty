package IM.codec;

import IM.packet.Packet;
import IM.packet.login.LoginRequestPacket;
import IM.packet.login.LoginResponsePacket;
import IM.packet.message.MessageRequestPacket;
import IM.packet.message.MessageResponsePacket;
import IM.serialize.JSONSerializer;
import IM.serialize.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.HashMap;
import java.util.Map;

import static IM.command.Command.*;

/**
 * @author lixt
 */
public class PacketCodec {
    public static final PacketCodec INSTANCE = new PacketCodec();
    public static final int MAGIC_NUMBER = 0x12345678;
    private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private static final Map<Byte, Serializer> serializerMap;

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE, MessageResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        //2. 序列化对象
        byte[] serialize = Serializer.DEFAULT.serialize(packet);
        //3. 装填数据
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(serialize.length);
        byteBuf.writeBytes(serialize);
        return byteBuf;
    }

    public Packet decode(ByteBuf byteBuf) {
        //跳过魔数
        byteBuf.skipBytes(4);
        //跳过版本号
        byteBuf.skipBytes(1);
        //获取算法标识
        byte serializeAlgorithm = byteBuf.readByte();
        //指令
        byte command = byteBuf.readByte();
        //长度
        int len = byteBuf.readInt();
        //数据
        byte[] bytes = new byte[len];
        byteBuf.readBytes(bytes);

        Serializer serializer = getSerializer(serializeAlgorithm);
        Class<? extends Packet> requestType = getRequestType(command);
        if (serializer != null && requestType != null) {
            Packet packet = serializer.deserialize(requestType, bytes);
            return packet;
        }
        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {

        return packetTypeMap.get(command);
    }
}
