package vn.myclass.core.service;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;

/**
 * Created by Admin on 9/7/2017.
 */
public interface UserService {
    UserDTO isUserExist(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
}
