package vn.myclass.command;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 8/7/2017.
 */
public class UserCommand extends AbstractCommand<UserDTO> {
    private String confirmPassword;
    public UserCommand() {
        this.pojo = new UserDTO();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
