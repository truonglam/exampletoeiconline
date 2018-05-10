package vn.myclass.command;

import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.dto.ExaminationQuestionImportDTO;
import vn.myclass.core.web.command.AbstractCommand;

import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationCommand extends AbstractCommand<ExaminationDTO> {
	public ExaminationCommand() {
		this.pojo = new ExaminationDTO();
	}
	private List<ExaminationDTO> examinationDTOS;

	public List<ExaminationDTO> getExaminationDTOS() {
		return examinationDTOS;
	}

	public void setExaminationDTOS(List<ExaminationDTO> examinationDTOS) {
		this.examinationDTOS = examinationDTOS;
	}
}
