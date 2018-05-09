package vn.myclass.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vn.myclass.core.dao.ExerciseDao;
import vn.myclass.core.dao.ExerciseResultDao;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.ExerciseDaoImpl;
import vn.myclass.core.daoimpl.ExerciseResultDaoImpl;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.dto.ExerciseResultDTO;
import vn.myclass.core.persistence.entity.ExerciseEntity;
import vn.myclass.core.persistence.entity.ExerciseResultEntity;
import vn.myclass.core.persistence.entity.UserEntity;
import vn.myclass.core.service.ExerciseResultService;
import vn.myclass.core.utils.ExerciseResultBeanUtil;

public class ExerciseResultServiceImpl implements ExerciseResultService {
	
	private ExerciseDao exerciseDao;
	private UserDao userDao;
	private ExerciseResultDao exerciseResultDao;
	
	public ExerciseResultServiceImpl() {
		exerciseDao = new ExerciseDaoImpl();
		userDao = new UserDaoImpl();
		exerciseResultDao = new ExerciseResultDaoImpl();
	}

	@Override
	public void saveExerciseResult(List<ExerciseQuestionDTO> exerciseQuestions, Integer exerciseId, String userName) {
		ExerciseResultEntity exerciseResult = new ExerciseResultEntity();
		exerciseResult.setTotal(exerciseQuestions.size());
		exerciseResult.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		ExerciseEntity exercise = exerciseDao.findById(exerciseId);
		UserEntity user = userDao.findEqualUnique("name", userName);
		exerciseResult.setExercise(exercise);
		exerciseResult.setUser(user);
		Integer numberOfCorrect = 0;
		for (ExerciseQuestionDTO item: exerciseQuestions) {
			if (item.getAnswerUser().equals(item.getCorrectAnswer())) {
				numberOfCorrect++;
			}
		}
		exerciseResult.setNumberOfCorrect(numberOfCorrect);
		exerciseResultDao.save(exerciseResult);
	}

	@Override
	public List<ExerciseResultDTO> getExerciseResultsByUser(String userName, Integer exerciseId) {
		List<ExerciseResultDTO> exerciseResultDTOs = new ArrayList<>();
		UserEntity user = userDao.findEqualUnique("name", userName);
		List<ExerciseResultEntity> exerciseResultEntities = new ArrayList<>();
		if (exerciseId != null && exerciseId != -1) {
			ExerciseEntity exercise = exerciseDao.findById(exerciseId);
			Map<String, Object> properties = new HashMap<>();
			properties.put("user", user);
			properties.put("exercise", exercise);
			exerciseResultEntities = exerciseResultDao.findByProperty(properties);
		} else {
			exerciseResultEntities = exerciseResultDao.findByProperty("user", user);
		}
		exerciseResultEntities.forEach(item -> {
			ExerciseResultDTO exerciseResultDTO = ExerciseResultBeanUtil.entity2Dto(item);
			exerciseResultDTOs.add(exerciseResultDTO);
		});
		return exerciseResultDTOs;
	}
}
