package vn.myclass.core.service.impl;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;
import vn.myclass.core.utils.ExaminationQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {
	public Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
		List<ExaminationQuestionDTO> result = new ArrayList<ExaminationQuestionDTO>();
		Object[] objects = SingletonDaoUtil.getExaminationQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, examinationId);
		int count = 1;
		for (ExaminationQuestionEntity item: (List<ExaminationQuestionEntity>)objects[1]) {
			ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(item);
			if (item.getParagraph() == null) {
				dto.setNumber(count);
				count++;
			}
			dto.setExamination(ExaminationBeanUtil.entity2Dto(item.getExamination()));
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}
}
