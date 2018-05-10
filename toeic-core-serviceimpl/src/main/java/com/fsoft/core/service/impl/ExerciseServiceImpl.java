package vn.myclass.core.service.impl;

import com.fsoft.core.dao.ExerciseDao;
import com.fsoft.core.daoimpl.ExerciseDaoImpl;
import com.fsoft.core.dto.ExerciseDTO;
import com.fsoft.core.persistence.entity.ExerciseEntity;
import vn.myclass.core.service.ExerciseService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExerciseBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseServiceImpl implements ExerciseService {
	
	private ExerciseDao exerciseDao;
	
	public ExerciseServiceImpl() {
		exerciseDao = new ExerciseDaoImpl();
	}
	
	public Object[] findExerciseByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
		List<ExerciseDTO> result = new ArrayList<ExerciseDTO>();
		Object[] objects = SingletonDaoUtil.getExerciseDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, null);
		for (ExerciseEntity item: (List<ExerciseEntity>)objects[1]) {
			ExerciseDTO dto = ExerciseBeanUtil.entity2Dto(item);
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}

	@Override
	public List<ExerciseDTO> getAll() {
		List<ExerciseDTO> exerciseDTOs = new ArrayList<>();
		List<ExerciseEntity> exerciseEntities = exerciseDao.findAll();
		exerciseEntities.forEach(item -> {
			ExerciseDTO exerciseDTO = ExerciseBeanUtil.entity2Dto(item);
			exerciseDTOs.add(exerciseDTO);
		});
		return exerciseDTOs;
	}
}
