package vn.myclass.core.service.impl;

import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.persistence.entity.ExerciseEntity;
import vn.myclass.core.persistence.entity.ExerciseQuestionEntity;
import vn.myclass.core.service.ExerciseQuestionService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExerciseBeanUtil;
import vn.myclass.core.utils.ExerciseQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 24/11/2017.
 */
public class ExerciseQuestionServiceImpl implements ExerciseQuestionService {

	public Object[] findExerciseQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer exerciseId) {
		List<ExerciseQuestionDTO> result = new ArrayList<ExerciseQuestionDTO>();
		String whereClause = null;
		if (exerciseId != null) {
			whereClause = " AND exerciseEntity.exerciseId = "+exerciseId+"";
		}
		Object[] objects = SingletonDaoUtil.getExerciseQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
		for (ExerciseQuestionEntity item: (List<ExerciseQuestionEntity>)objects[1]) {
			ExerciseQuestionDTO dto = ExerciseQuestionBeanUtil.entity2Dto(item);
			dto.setExercise(ExerciseBeanUtil.entity2Dto(item.getExerciseEntity()));
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}
}
