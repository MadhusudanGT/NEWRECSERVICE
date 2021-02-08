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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="documentModel")
public class DocumentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Document")
	private String Document;
	
	@Column(name="Url")
	private String Url;
	
	@Column(name="LastUpdate")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date LastUpdate;
	
	@OneToMany(targetEntity = ApplicationDocumentModel.class,mappedBy = "documentmodel", cascade = {CascadeType.ALL})
	 @JsonIgnore
	    private List<ApplicationDocumentModel> applicationdocumodel=new ArrayList<>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDocument() {
		return Document;
	}

	public void setDocument(String document) {
		Document = document;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public Date getLastUpdate() {
		return LastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		LastUpdate = lastUpdate;
	}

	public List<ApplicationDocumentModel> getApplicationdocumodel() {
		return applicationdocumodel;
	}

	public void setApplicationdocumodel(List<ApplicationDocumentModel> applicationdocumodel) {
		this.applicationdocumodel = applicationdocumodel;
	}

	public DocumentModel() {
		super();
	}
	@Override
	public String toString() {
		return "DocumentModel [Id=" + Id + ", Name=" + Name + ", Document=" + Document + ", Url=" + Url
				+ ", LastUpdate=" + LastUpdate + ", applicationdocumodel=" + applicationdocumodel + "]";
	}

	public DocumentModel(Long id, String name, String document, String url, Date lastUpdate,
			List<ApplicationDocumentModel> applicationdocumodel) {
		super();
		Id = id;
		Name = name;
		Document = document;
		Url = url;
		LastUpdate = lastUpdate;
		this.applicationdocumodel = applicationdocumodel;
	}
	
	
}
