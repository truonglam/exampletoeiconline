package vn.myclass.command;

import vn.myclass.core.dto.ResultDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 3/12/2017.
 */
public class ResultCommand extends AbstractCommand<ResultDTO> {
	public ResultCommand() {
		this.pojo = new ResultDTO();
	}
}
