package com.rec.model;


import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity

public class DbFile {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] image;

    public DbFile(){}
    
	public DbFile(Long id, String fileName, String fileType, byte[] image) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "DbFile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", image="
				+ Arrays.toString(image) + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
	
	
}