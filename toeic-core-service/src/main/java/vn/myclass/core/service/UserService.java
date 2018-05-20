package vn.myclass.core.service;

import com.restfb.types.User;
import vn.myclass.core.dto.CheckLogin;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.dto.UserImportDTO;
import vn.myclass.core.dto.UserRegisterDTO;
import vn.myclass.core.persistence.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 9/7/2017.
 */
public interface UserService {
    Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    UserDTO findById(Integer userId);
    void saveUser(UserDTO userDTO);
    boolean addUser(UserDTO userDTO) ;
    UserDTO updateUser(UserDTO userDTO);
    CheckLogin checkLogin(String name, String password);
    void validateImportUser(List<UserImportDTO> userImportDTOS);
    void saveUserImport(List<UserImportDTO> userImportDTOS);
    boolean loginFacebook(User user);
    void deleteUser(Integer id);
}
