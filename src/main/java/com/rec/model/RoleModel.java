package com.rec.model;

import java.util.ArrayList;  

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.JoinColumn;


@Entity
@Table(name="role")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class RoleModel {

			
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
//			@Pattern(regexp="^-?\\d{1,19}$")
//			@Size(min=1,max=30)
			private Long id;
			
			
			@NotNull(message="Title can not be null")
			@Column
			@Size(min=3,max=50)
			@Pattern(regexp="/^[A-Za-z]+$/")
			private String title;
			
			@Column
			@Size(min=3,max=80)
			@Pattern(regexp="/^[A-Za-z]+$/")
			private String description;
			
			@Temporal(value=TemporalType.TIMESTAMP)
			@CreatedDate
			@Column
			private Date createdAt;
			
			@Temporal(value=TemporalType.TIMESTAMP)
			@LastModifiedDate
			@Column
			private Date updatedAt;
			
			
			@ManyToMany(targetEntity = UserModel.class, mappedBy = "roles",  cascade = CascadeType.MERGE)
			private List<UserModel> users = new ArrayList<UserModel>();


			public Long getId() {
				return id;
			}	


			public void setId(Long id) {
				this.id = id;
			}


			public String getTitle() {
				return title;
			}


			public void setTitle(String title) {
				this.title = title;
			}


			public String getDescription() {
				return description;
			}


			public void setDescription(String description) {
				this.description = description;
			}


			public Date getCreatedAt() {
				return createdAt;
			}


			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}


			public Date getUpdatedAt() {
				return updatedAt;
			}


			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}


			public List<UserModel> getUsers() {
				return users;
			}


			public void setUsers(List<UserModel> users) {
				this.users = users;
			}


			public RoleModel() {
				super();
				// TODO Auto-generated constructor stub
			}


			public RoleModel(@Pattern(regexp = "^-?\\d{1,19}$") @Size(min = 1, max = 30) Long id,
					@NotNull(message = "Title can not be null") @Size(min = 3, max = 50) @Pattern(regexp = "/^[A-Za-z]+$/") String title,
					@Size(min = 3, max = 80) @Pattern(regexp = "/^[A-Za-z]+$/") String description, Date createdAt,
					Date updatedAt, List<UserModel> users) {
				super();
				this.id = id;
				this.title = title;
				this.description = description;
				this.createdAt = createdAt;
				this.updatedAt = updatedAt;
				this.users = users;
			}


			@Override
			public String toString() {
				return "RoleModel [id=" + id + ", title=" + title + ", description=" + description + ", createdAt="
						+ createdAt + ", updatedAt=" + updatedAt + ", users=" + users + "]";
			}


		


}