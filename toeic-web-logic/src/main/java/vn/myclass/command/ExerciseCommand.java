package vn.myclass.command;

import vn.myclass.core.dto.ExerciseDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 26/11/2017.
 */
public class ExerciseCommand extends AbstractCommand<ExerciseDTO> {
	public ExerciseCommand() {
		this.pojo = new ExerciseDTO();
	}
}
