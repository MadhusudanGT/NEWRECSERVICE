package com.rec.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="application_document")
public class ApplicationDocumentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="REC", sequenceName="id_seqence")
	private Long Id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Application_ID")
    private ApplicationModel application;
    
    public DocumentModel getDocument() {
		return document;
	}
	public void setDocument(DocumentModel document) {
		this.document = document;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Document_ID")
    private DocumentModel document;
	public ApplicationModel getApplication() {
		return application;
	}
	public void setApplication(ApplicationModel application) {
		this.application = application;
	}
	public ApplicationDocumentModel() {
		super();
		}
	public ApplicationDocumentModel(Long id) {
		super();
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
}
