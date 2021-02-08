package com.rec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="recruiter")
public class Recruiters {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	

	@OneToMany(targetEntity = ApplicationEvaluation.class, mappedBy="Recruiter", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<ApplicationEvaluation> applicationevaluation=new ArrayList<>();


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<ApplicationEvaluation> getApplicationevaluation() {
		return applicationevaluation;
	}


	public void setApplicationevaluation(List<ApplicationEvaluation> applicationevaluation) {
		this.applicationevaluation = applicationevaluation;
	}


	@Override
	public String toString() {
		return "Recruiters [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", applicationevaluation=" + applicationevaluation + "]";
	}
public Recruiters() {
	super();
}

	public Recruiters(Long id, String firstName, String lastName, List<ApplicationEvaluation> applicationevaluation) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.applicationevaluation = applicationevaluation;
	}
	
	
}
