package vn.myclass.core.utils;

import com.fsoft.core.dto.RoleDTO;
import com.fsoft.core.persistence.entity.RoleEntity;

/**
 * Created by Admin on 9/7/2017.
 */
public class RoleBeanUtil {
    public static RoleDTO entity2Dto(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        return dto;
    }
    public static RoleEntity dto2Entity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setName(dto.getName());
        return entity;
    }
}
