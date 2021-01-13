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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="application")
public class ApplicationModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="REC", sequenceName="id_seqence")
	private Long Id;
	
	@NotNull
//	@Temporal(TemporalType.DATE)
	private Date AppliedDate;

	@NotNull
	private String Education;
	
	@NotNull
	private String Experience;
	
	@NotNull
	private String OtherInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Applicant_ID")
    private ApplicantModel applicant;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Jobs_ID")
    private JobModel jobs;


	public JobModel getJobs() {
		return jobs;
	}
	public void setJobs(JobModel jobs) {
		this.jobs = jobs;
	}

	@OneToMany(targetEntity = ApplicationDocumentModel.class, mappedBy="application",cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<ApplicationDocumentModel> applicationDocument=new ArrayList<>();
     
	
public ApplicantModel getApplicant() {
		return applicant;
	}
	public void setApplicant(ApplicantModel applicant) {
		this.applicant = applicant;
	}
	//	public List<ApplicantModel> getApplicant() {
//		return applicant;
//	}
//	public void setApplicant(List<ApplicantModel> applicant) {
//		this.applicant = applicant;
//	}
	public List<ApplicationDocumentModel> getApplicationDocument() {
		return applicationDocument;
	}
	public void setApplicationDocument(List<ApplicationDocumentModel> applicationDocument) {
		this.applicationDocument = applicationDocument;
	}
	public ApplicationModel() {
		super();
		}
	public ApplicationModel(Long id, @NotNull Date appliedDate, @NotNull String education, @NotNull String experience,
			@NotNull String otherInfo, List<ApplicationModel> application) {
		super();
		Id = id;
		AppliedDate = appliedDate;
		Education = education;
		Experience = experience;
		OtherInfo = otherInfo;
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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	

}
