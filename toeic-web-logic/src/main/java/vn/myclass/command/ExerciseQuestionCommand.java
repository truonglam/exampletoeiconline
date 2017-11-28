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
}
