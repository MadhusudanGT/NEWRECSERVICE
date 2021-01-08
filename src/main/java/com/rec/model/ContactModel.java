package com.rec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;


@Entity
public class ContactModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="REC")
	@SequenceGenerator(name="REC", sequenceName="id_seqence")
	@Pattern(regexp="^-?\\d{1,19}$")
	@Size(min=1,max=30)
	private Long Id;
	
	@NotNull(message="User Id can not be null")
	@OneToOne(mappedBy="contact")
	private UserModel User;
	@NotNull(message="phone number can not be null")
	@Size(min=10)
	@Pattern(regexp="\"^\\\\d{10}$\"")
	private String PhoneNo1;
	
	@Size(min=10)
	@Pattern(regexp="\"^\\\\d{10}$\"")
	private String PhoneNo2;
	
	@NotNull(message="Addressline can not be null")
	@Size(min=10,max=80)
	private String AddressLine1;
	
	@Size(min=10,max=80)
	private String AddressLine2;
	
	@NotNull(message="State can not be null")
	@Pattern(regexp="/^[A-Za-z]+$/")
	@Size(min=10,max=40)
	private String State;
	
	@NotNull(message="Pincode can not be null")
	@Pattern(regexp="^-?\\d{1,19}$")
	@Column(name="Pincode")
	@Size(min=6,max=20)
	private Long Pincode;
	
	@NotNull(message="Country can not be null")
	@Pattern(regexp="/^[A-Za-z]+$/")
	@Size(min=10,max=40)
	private String Country;
	
	@Size(min=3,max=30)
	@Pattern(regexp="/^[A-Za-z]+$/")
	private String status;

//	public ContactModel() {
//		
//	}
//	public ContactModel( String phone1,String phone2,String address1,String address2,String state,Long pincode,String country,String status) {
//	  
//		 
//		this.PhoneNo1=phone1;
//		this.PhoneNo2=phone2;
//		this.AddressLine1=address1;
//		this.AddressLine2=address2;
//		this.State=state;
//		this.Pincode=pincode;
//		this.Country=country;
//		this.status=status;
//	}
	public Long  getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

 

	public UserModel getUserId() {
		return User;
	}

	public void setUserId(UserModel userId) {
		User = userId;
	}

	public UserModel getUser() {
		return User;
	}

	public void setUser(UserModel user) {
		User = user;
	}

	public String getPhoneNo1() {
		return PhoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		PhoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return PhoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		PhoneNo2 = phoneNo2;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Long getPincode() {
		return Pincode;
	}

	public void setPincode(Long pincode) {
		Pincode = pincode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 

}
