package com.rec.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Past;

import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="user")
public class UserModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Pattern(regexp="^-?\\d{1,19}$")
@Size(min=1,max=30)
private Long Id;

@NotNull(message="First name can not be null")
@Column(name="FirstName")
@Size(min=3,max=30)
@Pattern(regexp="/^[A-Za-z]+$/")
private String FirstName;

@NotNull(message="Last name can not be null")
@Size(min=3,max=30)
@Pattern(regexp="/^[A-Za-z]+$/")
@Column(name="LastName")
private String LastName;

@NotNull(message="Email can not be null")
@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s",
message="Email is invalid")
@Size(min=10,max=30)
@Column(name="Email",unique=true)
private String Email;

@NotNull(message="DOB cannot be null")
@Temporal(TemporalType.DATE)
@Pattern(regexp="dd-mm-yyyy",message="DOB is invalid")
@Column(name="DOB")
@Past
private Date DOB;

@Min(12)
@Pattern(regexp="^-?\\d{1,19}$",message="Adhar is invalid")
@Column(name="Adhar",unique=true)
private Long Adhar;

@Size(min=10,max=30)
@Pattern(regexp="/^[A-Za-z]+$/")
private String Status;

@Temporal(value=TemporalType.TIMESTAMP)
private Date CreatedAt;

@Temporal(value=TemporalType.TIMESTAMP)
private Date UpdatedAt;

@ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
private List<RoleModel> roles=new ArrayList<>();

public UserModel() {
super();
// TODO Auto-generated constructor stub
}

public UserModel(@Pattern(regexp = "^-?\\d{1,19}$") @Size(min = 1, max = 30) Long id,
@NotNull(message = "First name can not be null") @Size(min = 3, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String firstName,
@NotNull(message = "Last name can not be null") @Size(min = 3, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String lastName,
@NotNull(message = "Email can not be null") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s", message = "Email is invalid") @Size(min = 10, max = 30) String email,
@NotNull(message = "DOB cannot be null") @Pattern(regexp = "dd-mm-yyyy", message = "DOB is invalid") @Past Date dOB,
@Min(12) @Pattern(regexp = "^-?\\d{1,19}$", message = "Adhar is invalid") Long adhar,
@Size(min = 10, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String status, Date createdAt, Date updatedAt,
List<RoleModel> roles) {
super();
Id = id;
FirstName = firstName;
LastName = lastName;
Email = email;
DOB = dOB;
Adhar = adhar;
Status = status;
CreatedAt = createdAt;
UpdatedAt = updatedAt;
this.roles = roles;
}





public Long getId() {
return Id;
}

public void setId(Long id) {
Id = id;
}

public String getFirstName() {
return FirstName;
}

public void setFirstName(String firstName) {
FirstName = firstName;
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

public String getStatus() {
return Status;
}

public void setStatus(String status) {
Status = status;
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

public List<RoleModel> getRoles() {
return roles;
}

public void setRoles(List<RoleModel> roles) {
this.roles = roles;
}

}