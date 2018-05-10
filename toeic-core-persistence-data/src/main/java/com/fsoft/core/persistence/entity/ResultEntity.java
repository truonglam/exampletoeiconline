package vn.myclass.core.persistence.entity;

/**
 * Created by Admin on 24/11/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "result")
public class ResultEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resultId;

	@Column(name = "listenscore")
	private Integer listenScore;

	@Column(name = "readingscore")
	private Integer readingScore;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@ManyToOne
	@JoinColumn(name = "examinationid")
	private ExaminationEntity examination;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserEntity user;

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

	public ExaminationEntity getExamination() {
		return examination;
	}

	public void setExamination(ExaminationEntity examination) {
		this.examination = examination;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
