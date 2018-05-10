package vn.myclass.core.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsoft.core.dao.ExerciseDao;
import com.fsoft.core.dao.ExerciseResultDao;
import com.fsoft.core.dao.UserDao;
import com.fsoft.core.daoimpl.ExerciseDaoImpl;
import com.fsoft.core.daoimpl.ExerciseResultDaoImpl;
import com.fsoft.core.daoimpl.UserDaoImpl;
import com.fsoft.core.dto.ExerciseQuestionDTO;
import com.fsoft.core.dto.ExerciseResultDTO;
import com.fsoft.core.persistence.entity.ExerciseEntity;
import com.fsoft.core.persistence.entity.ExerciseResultEntity;
import com.fsoft.core.persistence.entity.UserEntity;
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
