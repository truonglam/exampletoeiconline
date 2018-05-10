package vn.myclass.core.service;

import java.util.List;

import com.fsoft.core.dto.ExerciseQuestionDTO;
import com.fsoft.core.dto.ExerciseResultDTO;

public interface ExerciseResultService {
	void saveExerciseResult(List<ExerciseQuestionDTO> exerciseQuestions, Integer exerciseId, String userName);
	List<ExerciseResultDTO> getExerciseResultsByUser(String userName, Integer exerciseId);
}
