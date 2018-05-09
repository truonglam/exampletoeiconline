package vn.myclass.command;

import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.dto.ExaminationQuestionImportDTO;
import vn.myclass.core.web.command.AbstractCommand;

import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationQuestionCommand extends AbstractCommand<ExaminationQuestionDTO> {
	public ExaminationQuestionCommand() {
		this.pojo = new ExaminationQuestionDTO();
	}
	private Integer examinationId;
	private Integer listenScore;
	private Integer readingScore;
	private List<ExaminationDTO> examinationDTOS;
	private List<ExaminationQuestionImportDTO> examinationQuestionImportDTOS;

	public List<ExaminationQuestionImportDTO> getExaminationQuestionImportDTOS() {
		return examinationQuestionImportDTOS;
	}

	public void setExaminationQuestionImportDTOS(List<ExaminationQuestionImportDTO> examinationQuestionImportDTOS) {
		this.examinationQuestionImportDTOS = examinationQuestionImportDTOS;
	}

	public List<ExaminationDTO> getExaminationDTOS() {
		return examinationDTOS;
	}

	public void setExaminationDTOS(List<ExaminationDTO> examinationDTOS) {
		this.examinationDTOS = examinationDTOS;
	}
	public Integer getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Integer examinationId) {
		this.examinationId = examinationId;
	}

	public Integer getListenScore() {
		return listenScore;
	}

	public void setListenScore(Integer listenScore) {
		this.listenScore = listenScore;
	}

	public Integer getReadingScore() {
		return readingScore;
	}

	public void setReadingScore(Integer readingScore) {
		this.readingScore = readingScore;
	}
}
