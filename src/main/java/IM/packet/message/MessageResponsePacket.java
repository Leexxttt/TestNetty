package IM.packet.message;

import IM.command.Command;
import IM.packet.Packet;
import lombok.Data;

/**
 * @author lixt
 */
@Data
public class MessageResponsePacket extends Packet {
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
