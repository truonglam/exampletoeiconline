package vn.myclass.core.utils;

import com.fsoft.core.dto.ExerciseResultDTO;
import com.fsoft.core.persistence.entity.ExerciseResultEntity;

public class ExerciseResultBeanUtil {

	public static ExerciseResultDTO entity2Dto(ExerciseResultEntity entity) {
		ExerciseResultDTO dto = new ExerciseResultDTO();
		dto.setId(entity.getId());
		dto.setNumberOfCorrect(entity.getNumberOfCorrect());
		dto.setTotal(entity.getTotal());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setUser(UserBeanUtil.entity2Dto(entity.getUser()));
		dto.setExercise(ExerciseBeanUtil.entity2Dto(entity.getExercise()));
		return dto;
	}
	public static ExerciseResultEntity dto2Entity(ExerciseResultDTO dto) {
		ExerciseResultEntity entity = new ExerciseResultEntity();
		entity.setId(dto.getId());
		entity.setNumberOfCorrect(dto.getNumberOfCorrect());
		entity.setTotal(dto.getTotal());
		entity.setCreatedDate(dto.getCreatedDate());
		entity.setUser(UserBeanUtil.dto2Entity(dto.getUser()));
		entity.setExercise(ExerciseBeanUtil.dto2Entity(dto.getExercise()));
		return entity;
	}
}
