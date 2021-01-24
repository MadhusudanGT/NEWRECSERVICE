package com.rec.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
 
        property = "id")
public class Recruiters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
	private String firstName;
	private String lastName;
	
	@OneToMany(targetEntity = ApplicationEvaluation.class, mappedBy = "Recruiter", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<ApplicationEvaluation> application =new ArrayList<>();
	
	public List<ApplicationEvaluation> getApplication() {
		return application;
	}
	public void setApplication(List<ApplicationEvaluation> application) {
		this.application = application;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
 
	
	

}