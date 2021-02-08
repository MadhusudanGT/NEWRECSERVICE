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
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Pattern;



import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name="Interview")
public class InterviewModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;

@Column(name="ApplicationId")
private Long ApplicationId;

@Column(name="StartTime",unique=true)
@Temporal(value=TemporalType.TIMESTAMP)
private Date StartTime;

@Column(name="EndTime",unique=true)
@Temporal(value=TemporalType.TIMESTAMP)
private Date EndTime;

@OneToMany(targetEntity = InterviewNoteModel.class, mappedBy="interviewmodel", cascade = {CascadeType.ALL})
@JsonIgnore
private List<InterviewNoteModel> interviewnotemodel=new ArrayList<>();
public InterviewModel() {
super();
// TODO Auto-generated constructor stub
}
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
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
public List<InterviewNoteModel> getInterviewnotemodel() {
	return interviewnotemodel;
}
public void setInterviewnotemodel(List<InterviewNoteModel> interviewnotemodel) {
	this.interviewnotemodel = interviewnotemodel;
}
@Override
public String toString() {
	return "InterviewModel [Id=" + Id + ", ApplicationId=" + ApplicationId + ", StartTime=" + StartTime + ", EndTime="
			+ EndTime + ", interviewnotemodel=" + interviewnotemodel + "]";
}
public InterviewModel(Long id, Long applicationId, Date startTime, Date endTime,
		List<InterviewNoteModel> interviewnotemodel) {
	super();
	Id = id;
	ApplicationId = applicationId;
	StartTime = startTime;
	EndTime = endTime;
	this.interviewnotemodel = interviewnotemodel;
}



}

