package com.rec.model;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.persistence.Table;

@Entity
@Table(name="Answers")
public class AnswersModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;

@Column(name="ApplicationTest")
private Long ApplicationTest;

@Column(name="Recruiterid")
private Long Recruiterid;

@Column(name="TotalGrades")
private Long TotalGrades;

@Column(name="Pass")
private boolean Pass;

@Column(name="AnswerDetials",unique=true)
private String AnswerDetials;

@ManyToOne(cascade = CascadeType.ALL)
private ApplicationTestModel atm;

public AnswersModel() {
super();
// TODO Auto-generated constructor stub
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public Long getApplicationTest() {
	return ApplicationTest;
}

public void setApplicationTest(Long applicationTest) {
	ApplicationTest = applicationTest;
}

public Long getRecruiterid() {
	return Recruiterid;
}

public void setRecruiterid(Long recruiterid) {
	Recruiterid = recruiterid;
}

public Long getTotalGrades() {
	return TotalGrades;
}

public void setTotalGrades(Long totalGrades) {
	TotalGrades = totalGrades;
}

public boolean isPass() {
	return Pass;
}

public void setPass(boolean pass) {
	Pass = pass;
}

public String getAnswerDetials() {
	return AnswerDetials;
}

public void setAnswerDetials(String answerDetials) {
	AnswerDetials = answerDetials;
}

public ApplicationTestModel getAtm() {
	return atm;
}

public void setAtm(ApplicationTestModel atm) {
	this.atm = atm;
}

@Override
public String toString() {
	return "AnswersModel [Id=" + Id + ", ApplicationTest=" + ApplicationTest + ", Recruiterid=" + Recruiterid
			+ ", TotalGrades=" + TotalGrades + ", Pass=" + Pass + ", AnswerDetials=" + AnswerDetials + ", atm=" + atm
			+ "]";
}

public AnswersModel(Long id, Long applicationTest, Long recruiterid, Long totalGrades, boolean pass,
		String answerDetials, ApplicationTestModel atm) {
	super();
	Id = id;
	ApplicationTest = applicationTest;
	Recruiterid = recruiterid;
	TotalGrades = totalGrades;
	Pass = pass;
	AnswerDetials = answerDetials;
	this.atm = atm;
}


}
