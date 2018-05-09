package vn.myclass.core.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.util.HibernateUtil;
import vn.myclass.core.dao.ExaminationDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.entity.ExaminationEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24/11/2017.
 */
public class ExaminationDaoImpl extends AbstractDao<Integer, ExaminationEntity> implements ExaminationDao {
}
