package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Admin on 3/12/2017.
 */
public class ResultDTO implements Serializable {
	private Integer resultId;
	private Integer listenScore;
	private Integer readingScore;
	private Timestamp createdDate;
	private ExaminationDTO examination;
	private UserDTO user;

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public ExaminationDTO getExamination() {
		return examination;
	}

	public void setExamination(ExaminationDTO examination) {
		this.examination = examination;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
