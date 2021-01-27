package com.rec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="applicant")
public class ApplicantModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="REC", sequenceName="id_seqence")
	private Long Id;
	
    
	@NotNull
	private String FirstName;

	@NotNull
	private String LastName;
	
	
	@NotNull
	private String Email;
	
	@NotNull
	private String PhoneNo;
   

	@NotNull
	private String summary;
	
	@OneToMany(targetEntity = ApplicationModel.class, mappedBy="applicant",cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<ApplicationModel> application1=new ArrayList<>();
	
	public List<ApplicationModel> getApplication1() {
		return application1;
	}
	public void setApplication1(List<ApplicationModel> application1) {
		this.application1 = application1;
	}
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		summary = summary;
	}
	

	@OneToMany(targetEntity = ApplicationDocumentModel.class,cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<ApplicationModel> application=new ArrayList<>();


	public List<ApplicationModel> getApplication() {
		return application1;
	}
	public void setApplication(List<ApplicationModel> application) {
		this.application1 = application;
	}
	public ApplicantModel() {
	super();
	}
	
	public ApplicantModel(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
			@NotNull String phoneNo, @NotNull String summary, List<ApplicationModel> application1,
			List<ApplicationModel> application) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNo = phoneNo;
		summary = summary;
		this.application1 = application1;
		this.application1 = application;
	}
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
	
}
