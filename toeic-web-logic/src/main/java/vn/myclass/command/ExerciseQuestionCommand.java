package vn.myclass.command;

import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 26/11/2017.
 */
public class ExerciseQuestionCommand extends AbstractCommand<ExerciseQuestionDTO> {
	public ExerciseQuestionCommand() {
		this.pojo = new ExerciseQuestionDTO();
	}
	private Integer exerciseId;
	private String answerUser;
	private boolean checkAnswer;

	public Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getAnswerUser() {
		return answerUser;
	}

	public void setAnswerUser(String answerUser) {
		this.answerUser = answerUser;
	}

	public boolean isCheckAnswer() {
		return checkAnswer;
	}

	public void setCheckAnswer(boolean checkAnswer) {
		this.checkAnswer = checkAnswer;
	}
}
