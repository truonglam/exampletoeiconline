package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 24/11/2017.
 */
@Entity
@Table(name = "examination")
public class ExaminationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examinationId;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@Column(name = "modifieddate")
	private Timestamp modifiedDate;

	@OneToMany(mappedBy = "examination", fetch = FetchType.LAZY)
	private List<ExaminationQuestionEntity> examinationQuestions;

	@OneToMany(mappedBy = "examination", fetch = FetchType.LAZY)
	private List<ResultEntity> results;

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

	public List<ExaminationQuestionEntity> getExaminationQuestions() {
		return examinationQuestions;
	}

	public void setExaminationQuestions(List<ExaminationQuestionEntity> examinationQuestions) {
		this.examinationQuestions = examinationQuestions;
	}

	public List<ResultEntity> getResults() {
		return results;
	}

	public void setResults(List<ResultEntity> results) {
		this.results = results;
	}

	public Integer getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(Integer examinationId) {
		this.examinationId = examinationId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
