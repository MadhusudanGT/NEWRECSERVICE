package com.rec.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Jobs")
public class JobModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="vacancy")
	private String vacancy;
	
	@Column(name="startingDate")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date startingDate;
	
	@Column(name="endingDate")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date endingDate;

	@Column(name="datePublished")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date datePublished;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private JobPlatform jobPlatform;
    
	@ManyToOne(cascade = CascadeType.ALL)
    private JobPosition jobPosition;
    
	@ManyToOne(cascade = CascadeType.ALL)
    private OrganizationModel organization;
//    
//	@OneToMany(targetEntity = ApplicationModel.class,mappedBy = "jobs", cascade = {CascadeType.ALL})
//	 @JsonIgnore
//	    private List<ApplicationModel> applicationmodel=new ArrayList<>();
//		
//	public List<ApplicationModel> getApplicationmodel() {
//		return applicationmodel;
//	}
//
//	public void setApplicationmodel(List<ApplicationModel> applicationmodel) {
//		this.applicationmodel = applicationmodel;
//	}

	public JobModel() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public JobPlatform getJobPlatform() {
		return jobPlatform;
	}

	public void setJobPlatform(JobPlatform jobPlatform) {
		this.jobPlatform = jobPlatform;
	}

	public JobPosition getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(JobPosition jobPosition) {
		this.jobPosition = jobPosition;
	}

	public OrganizationModel getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationModel organization) {
		this.organization = organization;
	}
//
//	public List<ApplicationModel> getApplicationmodel() {
//		return applicationmodel;
//	}
//
//	public void setApplicationmodel(List<ApplicationModel> applicationmodel) {
//		this.applicationmodel = applicationmodel;
//	}

	@Override
	public String toString() {
		return "JobModel [Id=" + Id + ", name=" + name + ", description=" + description + ", vacancy=" + vacancy
				+ ", startingDate=" + startingDate + ", endingDate=" + endingDate + ", datePublished=" + datePublished
				+ ", jobPlatform=" + jobPlatform + ", jobPosition=" + jobPosition + ", organization=" + organization
			 + "]";
	}

	public JobModel(Long id, String name, String description, String vacancy, Date startingDate, Date endingDate,
			Date datePublished, JobPlatform jobPlatform, JobPosition jobPosition, OrganizationModel organization) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.vacancy = vacancy;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.datePublished = datePublished;
		this.jobPlatform = jobPlatform;
		this.jobPosition = jobPosition;
		this.organization = organization;
//		this.applicationmodel = applicationmodel;
	}




}