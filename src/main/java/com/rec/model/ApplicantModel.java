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
@Table(name="applicantModel")
public class ApplicantModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="PhoneNo")
	private String PhoneNo;
	
	@Column(name="Summary")
	private String Summary;
	
    
	@OneToMany(targetEntity = ApplicationModel.class,mappedBy = "applicantmodel", cascade = {CascadeType.ALL})
	 @JsonIgnore
	    private List<ApplicationModel> applicationmodel=new ArrayList<>();


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPhoneNo() {
		return PhoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}


	public String getSummary() {
		return Summary;
	}


	public void setSummary(String summary) {
		Summary = summary;
	}


	public List<ApplicationModel> getApplicationmodel() {
		return applicationmodel;
	}


	public void setApplicationmodel(List<ApplicationModel> applicationmodel) {
		this.applicationmodel = applicationmodel;
	}

	public ApplicantModel() {
		super();
	}
	@Override
	public String toString() {
		return "ApplicantModel [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + 
				", PhoneNo=" + PhoneNo + ", Summary=" + Summary + ", applicationmodel=" + applicationmodel + ", Email=" + Email +"]";
	}


	public ApplicantModel(Long id, String firstName, String lastName, String email, String phoneNo, String summary,
			List<ApplicationModel> applicationmodel) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNo = phoneNo;
		Summary = summary;
		this.applicationmodel = applicationmodel;
	}
	
	
}
