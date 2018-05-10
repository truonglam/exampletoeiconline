package vn.myclass.core.dto;

import java.sql.Timestamp;

public class ExerciseResultDTO {

	private Integer id;
	private Integer numberOfCorrect;
	private Integer total;
	private Timestamp createdDate;
	private ExerciseDTO exercise;
	private UserDTO user;

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

	public ExerciseDTO getExercise() {
		return exercise;
	}

	public void setExercise(ExerciseDTO exercise) {
		this.exercise = exercise;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
