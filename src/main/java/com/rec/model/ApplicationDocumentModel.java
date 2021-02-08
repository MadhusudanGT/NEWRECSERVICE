package com.rec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="applicationDocumentModel")
public class ApplicationDocumentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="documnetId")
	private Long documnetId;
	
	@Column(name="applicationId")
	private Long applicationId;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private ApplicationModel applicationmodel;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private DocumentModel documentmodel;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getDocumnetId() {
		return documnetId;
	}

	public void setDocumnetId(Long documnetId) {
		this.documnetId = documnetId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public ApplicationModel getApplicationmodel() {
		return applicationmodel;
	}

	public void setApplicationmodel(ApplicationModel applicationmodel) {
		this.applicationmodel = applicationmodel;
	}

	public DocumentModel getDocumentmodel() {
		return documentmodel;
	}

	public void setDocumentmodel(DocumentModel documentmodel) {
		this.documentmodel = documentmodel;
	}

	public ApplicationDocumentModel() {
		super();
	}
	@Override
	public String toString() {
		return "ApplicationDocumentModel [Id=" + Id + ", documnetId=" + documnetId + ", applicationId=" + applicationId
				+ ", applicationmodel=" + applicationmodel + ", documentmodel=" + documentmodel + "]";
	}

	public ApplicationDocumentModel(Long id, Long documnetId, Long applicationId, ApplicationModel applicationmodel,
			DocumentModel documentmodel) {
		super();
		Id = id;
		this.documnetId = documnetId;
		this.applicationId = applicationId;
		this.applicationmodel = applicationmodel;
		this.documentmodel = documentmodel;
	}
	
	
	
	
}
