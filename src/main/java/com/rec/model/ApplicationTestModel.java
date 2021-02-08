package com.rec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.validation.constraints.Pattern;



import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ApplicationTest")
public class ApplicationTestModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Pattern(regexp="^-?\\d{1,19}$")
@Size(min=1,max=30)
private Long Id;

@NotNull(message="Code can not be null")
@Column(name="Testid")
@Size(min=3,max=30)
private Long Testid;

@NotNull(message="Application can not be null")
@Size(min=3,max=30)
@Column(name="ApplicationId")
private Long ApplicationId;

@NotNull(message="StartTime can not be null")
@Column(name="StartTime",unique=true)
@Temporal(TemporalType.DATE)
private Date StartTime;


@NotNull(message="endtTime can not be null")
@Column(name="EndTime",unique=true)
@Temporal(TemporalType.DATE)
private Date EndTime;

@OneToMany(targetEntity = AnswersModel.class, mappedBy="atm", cascade = {CascadeType.ALL})
@JsonIgnore
private List<AnswersModel> answersmodel=new ArrayList<>();

@ManyToOne(cascade = CascadeType.MERGE)
//@JoinTable(
//        name="application_test",
//        joinColumns=
//        @JoinColumn( name="applicationtest_id", referencedColumnName="id"),
//        inverseJoinColumns=@JoinColumn(name="test_id", referencedColumnName="id"))
private TestModel appltest;

public ApplicationTestModel() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public Long getTestid() {
	return Testid;
}

public void setTestid(Long testid) {
	Testid = testid;
}

public Long getApplicationId() {
	return ApplicationId;
}

public void setApplicationId(Long applicationId) {
	ApplicationId = applicationId;
}

public Date getStartTime() {
	return StartTime;
}

public void setStartTime(Date startTime) {
	StartTime = startTime;
}

public Date getEndTime() {
	return EndTime;
}

public void setEndTime(Date endTime) {
	EndTime = endTime;
}

public List<AnswersModel> getAnswersmodel() {
	return answersmodel;
}

public void setAnswersmodel(List<AnswersModel> answersmodel) {
	this.answersmodel = answersmodel;
}

public TestModel getAppltest() {
	return appltest;
}

public void setAppltest(TestModel appltest) {
	this.appltest = appltest;
}

@Override
public String toString() {
	return "ApplicationTestModel [Id=" + Id + ", Testid=" + Testid + ", ApplicationId=" + ApplicationId + ", StartTime="
			+ StartTime + ", EndTime=" + EndTime + ", answersmodel=" + answersmodel + ", appltest=" + appltest + "]";
}

public ApplicationTestModel(@Pattern(regexp = "^-?\\d{1,19}$") @Size(min = 1, max = 30) Long id,
		@NotNull(message = "Code can not be null") @Size(min = 3, max = 30) Long testid,
		@NotNull(message = "Application can not be null") @Size(min = 3, max = 30) Long applicationId,
		@NotNull(message = "StartTime can not be null") Date startTime,
		@NotNull(message = "endtTime can not be null") Date endTime, List<AnswersModel> answersmodel,
		TestModel appltest) {
	super();
	Id = id;
	Testid = testid;
	ApplicationId = applicationId;
	StartTime = startTime;
	EndTime = endTime;
	this.answersmodel = answersmodel;
	this.appltest = appltest;
}

}