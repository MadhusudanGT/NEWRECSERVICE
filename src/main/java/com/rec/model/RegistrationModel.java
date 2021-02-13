package com.rec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="registration")
public class RegistrationModel {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
// @SequenceGenerator(name="REC", sequenceName="id_seqence")
private Long Id;


@NotNull
private String FirstName;

@NotNull
private String LastName;


@NotNull
private String Email;

@NotNull
private String PhoneNo;


@NotNull
private String Address;

@NotNull
private String Password;

@NotNull
private String registredStatus;



public String getRegistredStatus() {
	return registredStatus;
}

public void setRegistredStatus(String registredStatus) {
	this.registredStatus = registredStatus;
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

public String getPhoneNo() {
return PhoneNo;
}

public void setPhoneNo(String phoneNo) {
PhoneNo = phoneNo;
}

public String getAddress() {
return Address;
}

public void setAddress(String address) {
Address = address;
}

public String getPassword() {
return Password;
}

public void setPassword(String password) {
Password = password;
}

@Override
public String toString() {
return "RegistrationModel [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
+ Email + ", PhoneNo=" + PhoneNo + ", Address=" + Address + ", Password=" + Password + "]";
}
public RegistrationModel() {
super();
}
public RegistrationModel(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull String email,
@NotNull String phoneNo, @NotNull String address, @NotNull String password) {
super();
Id = id;
FirstName = firstName;
LastName = lastName;
Email = email;
PhoneNo = phoneNo;
Address = address;
Password = password;
}





}
