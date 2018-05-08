package vn.myclass.command;

import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.dto.ResultDTO;
import vn.myclass.core.web.command.AbstractCommand;

import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public class ResultCommand extends AbstractCommand<ResultDTO> {

	public ResultCommand() {
		this.pojo = new ResultDTO();
	}

	private List<ExaminationDTO> examinations;
	private String examinationCode;

	public List<ExaminationDTO> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<ExaminationDTO> examinations) {
		this.examinations = examinations;
	}

	public String getExaminationCode() {
		return examinationCode;
	}

	public void setExaminationCode(String examinationCode) {
		this.examinationCode = examinationCode;
	}
}
