package vn.myclass.core.service.impl;

import com.fsoft.core.dto.CheckLogin;
import com.fsoft.core.dto.RoleDTO;
import com.fsoft.core.dto.UserDTO;
import com.fsoft.core.dto.UserImportDTO;
import com.restfb.types.User;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fsoft.core.common.util.HibernateUtil;
import vn.myclass.core.dto.*;
import com.fsoft.core.persistence.entity.RoleEntity;
import com.fsoft.core.persistence.entity.UserEntity;
import vn.myclass.core.service.UserService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.UserBeanUtil;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Admin on 9/7/2017.
 */
public class UserServiceImpl implements UserService {
    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        Object[] objects = SingletonDaoUtil.getUserDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, null);
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();
        for (UserEntity item : (List<UserEntity>) objects[1]) {
            UserDTO userDTO = UserBeanUtil.entity2Dto(item);
            userDTOS.add(userDTO);
        }
        objects[1] = userDTOS;
        return objects;
    }

    public UserDTO findById(Integer userId) {
        UserEntity entity = SingletonDaoUtil.getUserDaoInstance().findById(userId);
        UserDTO dto = UserBeanUtil.entity2Dto(entity);
        return dto;
    }

    public void saveUser(UserDTO userDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        userDTO.setCreatedDate(createdDate);
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        SingletonDaoUtil.getUserDaoInstance().save(entity);
    }

    public boolean addUser(UserDTO userDTO) {
        if (!checkExistUserName(userDTO.getName())) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(2);
            userDTO.setRoleDTO(roleDTO);
            saveUser(userDTO);
            return true;
        }
        return false;
    }

    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity entity = UserBeanUtil.dto2Entity(userDTO);
        entity = SingletonDaoUtil.getUserDaoInstance().update(entity);
        userDTO = UserBeanUtil.entity2Dto(entity);
        return userDTO;
    }

    public CheckLogin checkLogin(String name, String password) {
        CheckLogin checkLogin = new CheckLogin();
        if (name != null && password != null) {
            Object[] objects = SingletonDaoUtil.getUserDaoInstance().checkLogin(name, password);
            checkLogin.setUserExist((Boolean) objects[0]);
            if (checkLogin.isUserExist()) {
                checkLogin.setRoleName(objects[1].toString());
            }
        }
        return checkLogin;
    }

    public void validateImportUser(List<UserImportDTO> userImportDTOS) {
        List<String> names = new ArrayList<String>();
        List<String> roles = new ArrayList<String>();

        for (UserImportDTO item : userImportDTOS) {
            if (item.isValid()) {
                names.add(item.getUserName());
                if (!roles.contains(item.getRoleName())) {
                    roles.add(item.getRoleName());
                }
            }
        }

        Map<String, UserEntity> userEntityMap = new HashMap<String, UserEntity>();
        Map<String, RoleEntity> roleEntityMap = new HashMap<String, RoleEntity>();
        if (names.size() > 0) {
            List<UserEntity> userEntities = SingletonDaoUtil.getUserDaoInstance().findByUsers(names);
            for (UserEntity item : userEntities) {
                userEntityMap.put(item.getName().toUpperCase(), item);
            }
        }
        if (roles.size() > 0) {
            List<RoleEntity> roleEntities = SingletonDaoUtil.getRoleDaoInstance().findByRoles(roles);
            for (RoleEntity item : roleEntities) {
                roleEntityMap.put(item.getName().toUpperCase(), item);
            }
        }

        for (UserImportDTO item : userImportDTOS) {
            String message = item.getError();
            if (item.isValid()) {
                UserEntity userEntity = userEntityMap.get(item.getUserName().toUpperCase());
                if (userEntity != null) {
                    message += "<br/>";
                    message += "tên đăng nhập tồn tại";
                }

                RoleEntity roleEntity = roleEntityMap.get(item.getRoleName().toUpperCase());
                if (roleEntity == null) {
                    message += "<br/>";
                    message += "Vai trò không tồn tại";
                }
                if (StringUtils.isNotBlank(message)) {
                    item.setValid(false);
                    item.setError(message.substring(5));
                }
            }
        }
    }

    public void saveUserImport(List<UserImportDTO> userImportDTOS) {
        for (UserImportDTO item : userImportDTOS) {
            if (item.isValid()) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName(item.getUserName());
                userEntity.setFullName(item.getFullName());
                userEntity.setPassword(item.getPassword());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                userEntity.setCreatedDate(timestamp);
                RoleEntity roleEntity = SingletonDaoUtil.getRoleDaoInstance().findEqualUnique("name", item.getRoleName().toUpperCase());
                userEntity.setRoleEntity(roleEntity);
                SingletonDaoUtil.getUserDaoInstance().save(userEntity);
            }
        }
    }

    public List<UserEntity> findByUser(String names) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM UserEntity ue WHERE ue.name =:names");
            Query query = session.createQuery(sql.toString());
            query.setParameter("names", names);
            userEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return userEntities;
    }


    private boolean checkExistUserName(String name) {
        if (findByUser(name).size() == 0)
            return false;
        return true;
    }

    public boolean loginFacebook(User user) {
        boolean isLogin = false;
        if (checkExistUserName(user.getUsername()))
            isLogin = true;
        else {
            UserDTO userRegisterDTO = new UserDTO();
            userRegisterDTO.setFullName(user.getName());
            userRegisterDTO.setName(user.getUsername());
            userRegisterDTO.setPassword(user.getId());
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(2);
            userRegisterDTO.setRoleDTO(roleDTO);
            isLogin=addUser(userRegisterDTO);
        }
        return isLogin;
    }
}
