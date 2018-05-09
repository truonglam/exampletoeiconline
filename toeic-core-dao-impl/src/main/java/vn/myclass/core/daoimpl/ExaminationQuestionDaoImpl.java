package vn.myclass.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.util.HibernateUtil;
import vn.myclass.core.dao.ExaminationQuestionDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationQuestionDaoImpl extends AbstractDao<Integer, ExaminationQuestionEntity> implements ExaminationQuestionDao {

	public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
		String whereClause = null;
		if (examinationId != null) {
			whereClause = " AND examination.examinationId = "+examinationId+"";
		}
		return super.findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
	}

	public List<ExaminationQuestionEntity> findByExamination(List<String> names) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<ExaminationQuestionEntity> userEntities = new ArrayList<ExaminationQuestionEntity>();
		try {
			//TODO
			StringBuilder sql = new StringBuilder(" FROM ExaminationQuestionEntity ue WHERE ue.name IN(:code) ");
			Query query = session.createQuery(sql.toString());
			query.setParameterList("code", names);
			userEntities = query.list();
		} catch (HibernateException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
		return userEntities;
	}
}
