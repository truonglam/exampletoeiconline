package vn.myclass.core.service;

import java.util.Map;

/**
 * Created by Admin on 24/11/2017.
 */
public interface ExaminationQuestionService {
	Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId);
}
