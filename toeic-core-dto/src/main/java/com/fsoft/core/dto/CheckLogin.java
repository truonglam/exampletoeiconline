package vn.myclass.core.dto;

import java.io.Serializable;

/**
 * Created by Admin on 3/9/2017.
 */
public class CheckLogin implements Serializable {
    private boolean isUserExist;
    private String roleName;

    public boolean isUserExist() {
        return isUserExist;
    }

    public void setUserExist(boolean userExist) {
        isUserExist = userExist;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
