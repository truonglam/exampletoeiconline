package vn.myclass.core.dao;

import vn.myclass.core.data.dao.GenericDao;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;

import java.util.Map;

public interface ExaminationQuestionDao extends GenericDao<Integer, ExaminationQuestionEntity> {
	Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId);
}
