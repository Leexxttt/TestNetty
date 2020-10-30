package IM.packet.login;

import IM.command.Command;
import IM.packet.Packet;
import lombok.Data;

/**
 * @author lixt
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
