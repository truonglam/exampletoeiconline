package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationDTO implements Serializable {
	private Integer examinationId;
	private String name;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private List<ExaminationQuestionDTO> examinationQuestions;
	private List<ResultDTO> results;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<ExaminationQuestionDTO> getExaminationQuestions() {
		return examinationQuestions;
	}

	public void setExaminationQuestions(List<ExaminationQuestionDTO> examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}

	public List<ResultDTO> getResults() {
		return results;
	}

	public void setResults(List<ResultDTO> results) {
		this.results = results;
	}

	public Integer getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Integer examinationId) {
		this.examinationId = examinationId;
	}
}
