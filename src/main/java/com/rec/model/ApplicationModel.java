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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="applicationModel")
public class ApplicationModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="AppliedDate")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date AppliedDate;
	
	@Column(name="Education")
	private String Education;
	
	@Column(name="Experience")
	private String Experience;
	
	@Column(name="OtherInfo")
	private String OtherInfo;
	
	@Column(name="jobId")
	private Long jobId;
	
	@Column(name="applicantId")
	private Long applicantId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private ApplicantModel applicantmodel;
	
	@OneToMany(targetEntity = ApplicationDocumentModel.class,mappedBy = "applicationmodel", cascade = {CascadeType.ALL})
	    private List<ApplicationDocumentModel> applicationdocumodel=new ArrayList<>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getAppliedDate() {
		return AppliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		AppliedDate = appliedDate;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getOtherInfo() {
		return OtherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		OtherInfo = otherInfo;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public ApplicantModel getApplicantmodel() {
		return applicantmodel;
	}

	public void setApplicantmodel(ApplicantModel applicantmodel) {
		this.applicantmodel = applicantmodel;
	}

	public List<ApplicationDocumentModel> getApplicationdocumodel() {
		return applicationdocumodel;
	}

	public void setApplicationdocumodel(List<ApplicationDocumentModel> applicationdocumodel) {
		this.applicationdocumodel = applicationdocumodel;
	}

	public ApplicationModel() {
		super();
	}
	@Override
	public String toString() {
		return "ApplicationModel [Id=" + Id + ", AppliedDate=" + AppliedDate + ", Education=" + Education
				+ ", Experience=" + Experience + ", OtherInfo=" + OtherInfo + ", jobId=" + jobId + ", applicantId="
				+ applicantId + ", applicantmodel=" + applicantmodel + ", applicationdocumodel=" + applicationdocumodel
				+ "]";
	}

	public ApplicationModel(Long id, Date appliedDate, String education, String experience, String otherInfo,
			Long jobId, Long applicantId, ApplicantModel applicantmodel,
			List<ApplicationDocumentModel> applicationdocumodel) {
		super();
		Id = id;
		AppliedDate = appliedDate;
		Education = education;
		Experience = experience;
		OtherInfo = otherInfo;
		this.jobId = jobId;
		this.applicantId = applicantId;
		this.applicantmodel = applicantmodel;
		this.applicationdocumodel = applicationdocumodel;
	}
	
	
}
