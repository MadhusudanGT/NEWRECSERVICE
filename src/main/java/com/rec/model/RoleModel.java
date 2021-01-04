package com.rec.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
 

@Entity
//@SequenceGenerator(name="REC", initialValue=1000)
@Table(name="Role")
public class RoleModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REC")
	private Long Id;
	
	@NotNull
	@Column(name="UserId")
	private Long UserId;
	
	@NotNull
	@Column(name="Title")
	private String Title;
	
	
	private String Description;

	@Temporal(value=TemporalType.TIMESTAMP)
	private Date CreatedAt;
	 
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date UpdatedAt;
	
	RoleModel(){
		
	}
	
	public RoleModel( Long UserId, String Title, String Description, Date CreateAt,Date UpdateAt) {
	  
		this.UserId=UserId;
		this.Title=Title;
		
		this.Description=Description;
		this.CreatedAt=CreateAt;
		this.UpdatedAt=UpdateAt;
		
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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
