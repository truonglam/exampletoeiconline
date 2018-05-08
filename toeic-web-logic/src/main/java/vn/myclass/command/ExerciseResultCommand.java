package vn.myclass.command;

import vn.myclass.core.dto.ExerciseResultDTO;
import vn.myclass.core.web.command.AbstractCommand;

public class ExerciseResultCommand extends AbstractCommand<ExerciseResultDTO> {

	public ExerciseResultCommand() {
		this.pojo = new ExerciseResultDTO();
	}
}
