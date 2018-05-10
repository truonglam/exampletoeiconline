package vn.myclass.command;

import com.fsoft.core.dto.RoleDTO;
import com.fsoft.core.dto.UserDTO;
import com.fsoft.core.dto.UserImportDTO;
import vn.myclass.core.web.command.AbstractCommand;

import java.util.List;

/**
 * Created by Admin on 8/7/2017.
 */
public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand() {
        this.pojo = new UserDTO();
    }
    private String confirmPassword;
    private List<RoleDTO> roles;
    private Integer roleId;
    private List<UserImportDTO> userImportDTOS;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<UserImportDTO> getUserImportDTOS() {
        return userImportDTOS;
    }

    public void setUserImportDTOS(List<UserImportDTO> userImportDTOS) {
        this.userImportDTOS = userImportDTOS;
    }
}
