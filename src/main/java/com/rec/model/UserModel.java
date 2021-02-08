package com.rec.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Past;

import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="user")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserModel {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Pattern(regexp="^-?\\d{1,19}$")
		@Size(min=1,max=30)
		private Long id;
		
		@NotNull(message="First name can not be null")
		@Column
		@Size(min=3,max=30)
		@Pattern(regexp="/^[A-Za-z]+$/")
		private String firstName;
		
		@NotNull(message="Last name can not be null")
		@Size(min=3,max=30)
		@Pattern(regexp="/^[A-Za-z]+$/")
		@Column
		private String lastName;
		
		@NotNull(message="Email can not be null")
		@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s",
		message="Email is invalid")
		@Size(min=10,max=30)
		@Column(unique=true)
		private String email;
		
		@NotNull(message="DOB cannot be null")
		@Temporal(TemporalType.DATE)
		@Pattern(regexp="dd-mm-yyyy",message="DOB is invalid")
		@Column
		@Past
		private Date DOB;
		
		@Min(12)
		@Pattern(regexp="^-?\\d{1,19}$",message="Adhar is invalid")
		@Column
		private String adhar;
		
		@Size(min=10,max=30)
		@Pattern(regexp="/^[A-Za-z]+$/")
		@Column
		private String status;
		
		@Column
		@Temporal(value=TemporalType.TIMESTAMP)
		private Date createdAt;
		
		@Column
		@Temporal(value=TemporalType.TIMESTAMP)
		private Date updatedAt;
	 
		@OneToOne(targetEntity=ContactModel.class,cascade = CascadeType.ALL)
		private ContactModel contact;


//		 @ManyToMany(targetEntity = RoleModel.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
		 @ManyToMany(targetEntity = RoleModel.class, cascade = {CascadeType.MERGE})
		    @JoinTable(
		            name="users_roles",
		            joinColumns=
		            @JoinColumn( name="user_id", referencedColumnName="id"),
		            inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
		private List<RoleModel> roles=new ArrayList<RoleModel>();


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Date getDOB() {
			return this.DOB;
		}


		public void setDOB(Date dOB) {
			this.DOB = dOB;
		}


		public String getAdhar() {
			return adhar;
		}


		public void setAdhar(String adhar) {
			this.adhar = adhar;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
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


		public ContactModel getContact() {
			return contact;
		}


		public void setContact(ContactModel contact) {
			this.contact = contact;
		}


		public List<RoleModel> getRoles() {
			return roles;
		}


		public void setRoles(List<RoleModel> roles) {
			this.roles = roles;
		}


		public UserModel() {
			super();
			// TODO Auto-generated constructor stub
		}


		public UserModel(@Pattern(regexp = "^-?\\d{1,19}$") @Size(min = 1, max = 30) Long id,
				@NotNull(message = "First name can not be null") @Size(min = 3, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String firstName,
				@NotNull(message = "Last name can not be null") @Size(min = 3, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String lastName,
				@NotNull(message = "Email can not be null") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$s", message = "Email is invalid") @Size(min = 10, max = 30) String email,
				@NotNull(message = "DOB cannot be null") @Pattern(regexp = "dd-mm-yyyy", message = "DOB is invalid") @Past Date DOB,
				@Min(12) @Pattern(regexp = "^-?\\d{1,19}$", message = "Adhar is invalid") String adhar,
				@Size(min = 10, max = 30) @Pattern(regexp = "/^[A-Za-z]+$/") String status, Date createdAt,
				Date updatedAt, ContactModel contact, List<RoleModel> roles) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.DOB = DOB;
			this.adhar = adhar;
			this.status = status;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.contact = contact;
			this.roles = roles;
		}


		@Override
		public String toString() {
			return "UserModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", DOB=" + DOB + ", adhar=" + adhar + ", status=" + status + ", CreatedAt=" + createdAt
					+ ", UpdatedAt=" + updatedAt + ", contact=" + contact + ", roles=" + roles + "]";
		}

			
		

}