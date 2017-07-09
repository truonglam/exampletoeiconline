package vn.myclass.command;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 8/7/2017.
 */
public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
}
