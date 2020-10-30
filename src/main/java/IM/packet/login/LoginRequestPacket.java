package IM.packet.login;

import IM.command.Command;
import IM.packet.Packet;
import lombok.Data;

/**
 * @author lixt
 */
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;
    private String username;
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
