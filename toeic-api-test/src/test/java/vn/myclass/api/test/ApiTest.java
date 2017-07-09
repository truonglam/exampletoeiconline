package vn.myclass.api.test;

import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;

/**
 * Created by Admin on 9/7/2017.
 */
public class ApiTest {
    @Test
    public void checkFindByProperty() {
        RoleDao roleDao = new RoleDaoImpl();
        String property = null;
        String value = null;
        String sortExpression = null;
        String sortDirection = null;
        Object[] objects = roleDao.findByProperty(property, value, sortExpression, sortDirection);
    }
}
