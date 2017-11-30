package vn.myclass.core.service;

import java.util.Map;

/**
 * Created by Admin on 24/11/2017.
 */
public interface ExerciseService {
	Object[] findExerciseByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
