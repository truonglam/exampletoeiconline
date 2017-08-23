package vn.myclass.core.service.impl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistence.entity.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.utils.UserBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 9/7/2017.
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    public UserDTO isUserExist(UserDTO dto) {
        UserEntity entity = userDao.findUserByUsernameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserEntity entity = userDao.findUserByUsernameAndPassword(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = userDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (UserEntity item: (List<UserEntity>)objects[1]) {
            UserDTO userDTO = UserBeanUtil.entity2Dto(item);
            userDTOS.add(userDTO);
        }
        objects[1] = userDTOS;
        return objects;
    }
}
