package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "exerciseresult")
public class ExerciseResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "numberofcorrect")
	private Integer numberOfCorrect;

	@Column(name = "total")
	private Integer total;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@ManyToOne
	@JoinColumn(name = "exerciseid")
	private ExerciseEntity exercise;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserEntity user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfCorrect() {
		return numberOfCorrect;
	}

	public void setNumberOfCorrect(Integer numberOfCorrect) {
		this.numberOfCorrect = numberOfCorrect;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public ExerciseEntity getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseEntity exercise) {
		this.exercise = exercise;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}
