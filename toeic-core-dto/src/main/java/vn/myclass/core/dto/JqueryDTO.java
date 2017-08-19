package vn.myclass.core.dto;

import java.io.Serializable;

/**
 * Created by Admin on 19/8/2017.
 */
public class JqueryDTO implements Serializable {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
