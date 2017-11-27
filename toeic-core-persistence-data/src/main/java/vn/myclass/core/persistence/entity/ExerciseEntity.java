package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 24/11/2017.
 */
@Entity
@Table(name = "exercise")
public class ExerciseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer exerciseId;

	@Column(name = "name")
	private String name;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@Column(name = "modifieddate")
	private Timestamp modifiedDate;

	@OneToMany(mappedBy = "exerciseEntity", fetch = FetchType.LAZY)
	private List<ExerciseQuestionEntity> exerciseQuestions;

	@Column(name = "type")
	private String type;

	public Integer getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(Integer exerciseId) {
		this.exerciseId = exerciseId;
	}

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

	public List<ExerciseQuestionEntity> getExerciseQuestions() {
		return exerciseQuestions;
	}

	public void setExerciseQuestions(List<ExerciseQuestionEntity> exerciseQuestions) {
		this.exerciseQuestions = exerciseQuestions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
