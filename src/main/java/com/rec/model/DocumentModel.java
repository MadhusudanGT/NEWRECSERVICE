package com.rec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="document")
public class DocumentModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@SequenceGenerator(name="REC", sequenceName="id_seqence")
	private Long Id;
	

	@NotNull
	private String Name;
	
	@NotNull
	private String Document;
	
	
	@NotNull
	private String Url;
	
	@NotNull
//	@Temporal(value=TemporalType.DATE)
	private String LastUpdate;
    
	@OneToMany(targetEntity = ApplicationDocumentModel.class, mappedBy="document",cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<ApplicationDocumentModel> applicationDocument=new ArrayList<>();
	
	public List<ApplicationDocumentModel> getApplicationDocument() {
		return applicationDocument;
	}
	public void setApplicationDocument(List<ApplicationDocumentModel> applicationDocument) {
		this.applicationDocument = applicationDocument;
	}
	public DocumentModel() {
		super();
		}
	public DocumentModel(Long id, @NotNull String name, @NotNull String document, @NotNull String url,
			@NotNull String lastUpdate) {
		super();
		Id = id;
		Name = name;
		Document = document;
		Url = url;
		LastUpdate = lastUpdate;
	}

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

	public String getLastUpdate() {
		return LastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		LastUpdate = lastUpdate;
	}
	

}
