package com.rec.model;
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
@Table(name="InterviewNote")
public class InterviewNoteModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;

@Size(min=3,max=30)
@Column(name="notes")
private String notes;


@Size(min=3,max=30)
@Column(name="InterviewId")
private Long InterviewId;

@Size(min=3,max=30)
@Column(name="RecruitersId")
private Long RecruitersId;

@Size(min=3,max=30)
@Column(name="Pass")
private boolean Pass;

@ManyToOne(cascade = CascadeType.MERGE)
private InterviewModel interviewmodel;;

public InterviewNoteModel() {
super();
// TODO Auto-generated constructor stub
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public Long getInterviewId() {
	return InterviewId;
}

public void setInterviewId(Long interviewId) {
	InterviewId = interviewId;
}

public Long getRecruitersId() {
	return RecruitersId;
}

public void setRecruitersId(Long recruitersId) {
	RecruitersId = recruitersId;
}

public boolean isPass() {
	return Pass;
}

public void setPass(boolean pass) {
	Pass = pass;
}

public InterviewModel getInterviewmodel() {
	return interviewmodel;
}

public void setInterviewmodel(InterviewModel interviewmodel) {
	this.interviewmodel = interviewmodel;
}

@Override
public String toString() {
	return "InterviewNoteModel [Id=" + Id + ", notes=" + notes + ", InterviewId=" + InterviewId + ", RecruitersId="
			+ RecruitersId + ", Pass=" + Pass + ", interviewmodel=" + interviewmodel + "]";
}

public InterviewNoteModel(Long id, @Size(min = 3, max = 30) String notes, @Size(min = 3, max = 30) Long interviewId,
		@Size(min = 3, max = 30) Long recruitersId, @Size(min = 3, max = 30) boolean pass,
		InterviewModel interviewmodel) {
	super();
	Id = id;
	this.notes = notes;
	InterviewId = interviewId;
	RecruitersId = recruitersId;
	Pass = pass;
	this.interviewmodel = interviewmodel;
}


}

