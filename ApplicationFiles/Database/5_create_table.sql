use toeiconline;

CREATE TABLE exercisetype (
  exercisetypeid bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(100) NOT NULL,
  code VARCHAR(100) NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null,
  unique(name)
);

CREATE TABLE exercise (
  exerciseid bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(100) NOT NULL,
  exercisetypeid BIGINT NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null,
  unique(name)
);

ALTER TABLE exercise ADD CONSTRAINT fk_exercise_exercisetype FOREIGN KEY (exercisetypeid) REFERENCES exercisetype(exercisetypeid);


CREATE TABLE exercisequestion (
  exercisequestionid bigint NOT NULL PRIMARY KEY auto_increment,
  image VARCHAR(255),
  audio VARCHAR(255),
  question TEXT NOT NULL,
  option1 VARCHAR(300) NOT NULL,
  option2 VARCHAR(300) NOT NULL,
  option3 VARCHAR(300) NOT NULL,
  option4 VARCHAR(300) NOT NULL,
  correctanswer VARCHAR(10) NOT NULL,
  exerciseid BIGINT NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null
);

ALTER TABLE exercisequestion ADD CONSTRAINT fk_exercisequestion_exercise FOREIGN KEY (exerciseid) REFERENCES exercise(exerciseid);

CREATE TABLE examination (
  examinationid bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null,
  unique(name)
);

CREATE TABLE examinationquestion (
  examinationquestionid bigint NOT NULL PRIMARY KEY auto_increment,
  image VARCHAR(255),
  audio VARCHAR(255),
  question TEXT NOT NULL,
  paragraph TEXT,
  option1 VARCHAR(300) NOT NULL,
  option2 VARCHAR(300) NOT NULL,
  option3 VARCHAR(300) NOT NULL,
  option4 VARCHAR(300) NOT NULL,
  correctanswer VARCHAR(10) NOT NULL,
  examinationid BIGINT NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null
);

ALTER TABLE examinationquestion ADD CONSTRAINT fk_examinationquestion_examination FOREIGN KEY (examinationid) REFERENCES examination(examinationid);


CREATE TABLE result (
  resultid bigint NOT NULL PRIMARY KEY auto_increment,
  listenscore INT NOT NULL,
  readingscore INT NOT NULL,
  examinationid BIGINT NOT NULL,
  userid BIGINT NOT NULL,
  createddate TIMESTAMP null,
  modifieddate TIMESTAMP null
);

ALTER TABLE result ADD CONSTRAINT fk_result_examination FOREIGN KEY (examinationid) REFERENCES examination(examinationid);
ALTER TABLE result ADD CONSTRAINT fk_result_user FOREIGN KEY (userid) REFERENCES user(userid);















