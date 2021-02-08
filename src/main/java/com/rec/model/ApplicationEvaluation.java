package com.rec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		 
        generator = ObjectIdGenerators.PropertyGenerator.class,
 
        property = "id")
public class ApplicationEvaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String Notes;
	
	private boolean hired;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Recruiters Recruiter;
	
//	@OneToOne(targetEntity  = ApplicationModel.class,cascade = CascadeType.ALL)
//	private Long applicationId;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private ApplicationModel applicationModel;


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNotes() {
		return Notes;
	}



	public void setNotes(String notes) {
		Notes = notes;
	}



	public boolean isHired() {
		return hired;
	}



	public void setHired(boolean hired) {
		this.hired = hired;
	}



	public Recruiters getRecruiter() {
		return Recruiter;
	}



	public void setRecruiter(Recruiters recruiter) {
		Recruiter = recruiter;
	}






	
	
	
	
}