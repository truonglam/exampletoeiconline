package vn.myclass.core.service;

import vn.myclass.core.dto.RoleDTO;

import java.util.List;

/**
 * Created by Admin on 26/8/2017.
 */
public interface RoleService {
    List<RoleDTO> findAll();
}
