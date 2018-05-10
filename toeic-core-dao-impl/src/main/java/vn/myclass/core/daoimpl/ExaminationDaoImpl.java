package vn.myclass.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import vn.myclass.core.common.util.HibernateUtil;
import vn.myclass.core.dao.ExaminationDao;
import vn.myclass.core.dao.ExaminationQuestionDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.entity.ExaminationEntity;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;

/**
 * Created by Admin on 24/11/2017.
 */
public class ExaminationDaoImpl extends AbstractDao<Integer, ExaminationEntity> implements ExaminationDao {

    public List<ExaminationQuestionEntity> findByCode(List<String> code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<ExaminationQuestionEntity> entities = new ArrayList<ExaminationQuestionEntity>();
        try {
            StringBuilder sql = new StringBuilder(" FROM ExaminationEntity ue WHERE ue.code IN(:code) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("code", code);
            entities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return entities;

    }
}
