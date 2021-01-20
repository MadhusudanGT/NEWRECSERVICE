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
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;


@Entity
@Table(name="Role")
public class RoleModel {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Pattern(regexp="^-?\\d{1,19}$")
@Size(min=1,max=30)
private Long Id;


@NotNull(message="Title can not be null")
@Column(name="Title")
@Size(min=3,max=50)
@Pattern(regexp="/^[A-Za-z]+$/")
private String Title;

@Column(name="Description")
@Size(min=3,max=80)
@Pattern(regexp="/^[A-Za-z]+$/")
private String Description;

@Temporal(value=TemporalType.TIMESTAMP)
@CreatedDate
@Column
private Date CreatedAt;

@Temporal(value=TemporalType.TIMESTAMP)
@LastModifiedDate
@Column
private Date UpdatedAt;


//@ManyToMany(cascade = CascadeType.ALL, mappedBy="roles")
//@JoinTable(name = "users_roles",
//joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
//inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id")
//)
//@JsonIgnore
//private List<UserModel> users=new ArrayList();


public RoleModel() {
super();
}

public RoleModel(@Pattern(regexp = "^-?\\d{1,19}$") @Size(min = 1, max = 30) Long id,
@NotNull(message = "Title can not be null") @Size(min = 3, max = 50) @Pattern(regexp = "/^[A-Za-z]+$/") String title,
@Size(min = 3, max = 80) @Pattern(regexp = "/^[A-Za-z]+$/") String description, Date createdAt,
Date updatedAt, List<UserModel> users) {
super();
Id = id;
Title = title;
Description = description;
CreatedAt = createdAt;
UpdatedAt = updatedAt;
//this.users = users;
}




public Long getId() {
return Id;
}


public void setId(Long id) {
Id = id;
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

//public List<UserModel> getUsers() {
//return users;
//}
//
//public void setUsers(List<UserModel> users) {
//this.users = users;
//}



}
