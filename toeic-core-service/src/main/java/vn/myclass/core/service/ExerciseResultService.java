package vn.myclass.core.service;

import java.util.List;

import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.dto.ExerciseResultDTO;

public interface ExerciseResultService {
	void saveExerciseResult(List<ExerciseQuestionDTO> exerciseQuestions, Integer exerciseId, String userName);
	List<ExerciseResultDTO> getExerciseResultsByUser(String userName, Integer exerciseId);
}
