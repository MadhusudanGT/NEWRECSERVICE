package com.rec.model;


import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Table;

@Entity
@Table(name="test")
public class TestModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;

@NotNull(message="Code can not be null")
@Column(name="code")
@Size(min=3,max=30)
private Long code;

@NotNull(message="Duration can not be null")
@Size(min=3,max=30)
@Column(name="duration")
private Long duration;

@NotNull(message="MaxScore can not be null")
@Column(name="maxscore")
private Long maxscore;

@OneToMany(targetEntity = ApplicationTestModel.class, mappedBy="appltest", cascade = {CascadeType.ALL})
@JsonIgnore
private List<ApplicationTestModel> applicationtestModel=new ArrayList<>();

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public Long getCode() {
	return code;
}

public void setCode(Long code) {
	this.code = code;
}

public Long getDuration() {
	return duration;
}

public void setDuration(Long duration) {
	this.duration = duration;
}

public Long getMaxscore() {
	return maxscore;
}

public void setMaxscore(Long maxscore) {
	this.maxscore = maxscore;
}

public List<ApplicationTestModel> getApplicationtestModel() {
	return applicationtestModel;
}

public void setApplicationtestModel(List<ApplicationTestModel> applicationtestModel) {
	this.applicationtestModel = applicationtestModel;
}

@Override
public String toString() {
	return "TestModel [Id=" + Id + ", code=" + code + ", duration=" + duration + ", maxscore=" + maxscore
			+ ", applicationtestModel=" + applicationtestModel + "]";
}

public TestModel() {
	super();
	Id = Id;
	this.code = code;
	this.duration = duration;
	this.maxscore = maxscore;
	this.applicationtestModel = applicationtestModel;
}

}