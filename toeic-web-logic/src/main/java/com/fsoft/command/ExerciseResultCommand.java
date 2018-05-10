package vn.myclass.command;

import java.util.List;

import com.fsoft.core.dto.ExerciseDTO;
import com.fsoft.core.dto.ExerciseResultDTO;
import vn.myclass.core.web.command.AbstractCommand;

public class ExerciseResultCommand extends AbstractCommand<ExerciseResultDTO> {

	public ExerciseResultCommand() {
		this.pojo = new ExerciseResultDTO();
	}
	
	private Integer exerciseId;
	private List<ExerciseDTO> exercises;
	
	public Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

	public List<ExerciseDTO> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseDTO> exercises) {
		this.exercises = exercises;
	}
}
