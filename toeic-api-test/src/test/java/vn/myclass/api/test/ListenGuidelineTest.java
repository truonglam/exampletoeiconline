package vn.myclass.api.test;

import org.junit.Test;
import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.daoimpl.UserDaoImpl;

/**
 * Created by Admin on 16/7/2017.
 */
public class ListenGuidelineTest {

    @Test
    public void testFindByProperties() {
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        Object[] result = listenGuidelineDao.findByProperty(null, null, null, null, 2, 2);
    }
}
