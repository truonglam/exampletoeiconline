package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Admin on 24/11/2017.
 */
@Entity
@Table(name = "examinationquestion")
public class ExaminationQuestionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examinationQuestionId;

	@Column(name = "image")
	private String image;

	@Column(name = "paragraph")
	private String paragraph;

	@Column(name = "audio")
	private String audio;

	@Column(name = "question")
	private String question;

	@Column(name = "option1")
	private String option1;

	@Column(name = "option2")
	private String option2;

	@Column(name = "option3")
	private String option3;

	@Column(name = "option4")
	private String option4;

	@Column(name = "correctanswer")
	private String correctAnswer;

	@Column(name = "createddate")
	private Timestamp createdDate;

	@Column(name = "modifieddate")
	private Timestamp modifiedDate;

	@ManyToOne
	@JoinColumn(name = "examinationid")
	private ExaminationEntity examination;

	public Integer getExaminationQuestionId() {
		return examinationQuestionId;
	}

	public void setExaminationQuestionId(Integer examinationQuestionId) {
		this.examinationQuestionId = examinationQuestionId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
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

	public ExaminationEntity getExamination() {
		return examination;
	}

	public void setExamination(ExaminationEntity examination) {
		this.examination = examination;
	}
}
