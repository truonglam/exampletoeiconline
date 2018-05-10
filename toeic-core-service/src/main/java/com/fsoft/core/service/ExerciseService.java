package vn.myclass.core.service;

import java.util.List;
import java.util.Map;

import com.fsoft.core.dto.ExerciseDTO;

/**
 * Created by Admin on 24/11/2017.
 */
public interface ExerciseService {
	Object[] findExerciseByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
	List<ExerciseDTO> getAll();
}
