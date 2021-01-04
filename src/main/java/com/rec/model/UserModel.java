package com.rec.model;


import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
 

@Entity
//@SequenceGenerator(name="REC", initialValue=1000)
@Table(name="user")
public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REC")
	private Long Id;
	
	@NotNull
	@Column(name="FirstName")
	private String FirstName;
	
	@NotNull
	@Column(name="LastName")
	private String LastName;
	
	@NotNull
	private String Email;
	
	@NotNull
	private Date DOB;
	
	private Long Adhar;
	
	private String Status;

	@Temporal(value=TemporalType.TIMESTAMP)
	private Date CreatedAt;
	 
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date UpdatedAt;
	
	UserModel(){
		
	}
	
	public UserModel( String Firstname, String Lastname,String Email,Date DOB,Long Adhar,String Status,Date CreateAt,Date UpdateAt) {
	  
		this.FirstName=Firstname;
		this.LastName=LastName;
		this.Email=Email;
		this.DOB=DOB;
		this.Adhar=Adhar;
		this.Status=Status;
		this.CreatedAt=CreateAt;
		this.UpdatedAt=UpdateAt;
		
		
	}
	
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
 

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstname() {
		return FirstName;
	}

	public void setFirstname(String firstname) {
		FirstName = firstname;
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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Long getAdhar() {
		return Adhar;
	}

	public void setAdhar(Long adhar) {
		Adhar = adhar;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}

	public Date getUpdatedAt() {
		return UpdatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		UpdatedAt = updatedAt;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
