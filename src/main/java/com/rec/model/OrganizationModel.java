package com.rec.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="organization")
	public class OrganizationModel {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long Id;
		
		@OneToMany(targetEntity =JobModel.class,mappedBy = "organization", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
		@JsonIgnore
	    private List<JobModel> jobmodel=new ArrayList<>();
		 
		 
		@Column(name="orgName")
		private String orgName;
		
		@Column(name="orgDescription")
		private String orgDescription;
		



		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public String getOrgDescription() {
			return orgDescription;
		}

		public void setOrgDescription(String orgDescription) {
			this.orgDescription = orgDescription;
		}


		public List<JobModel> getJobmodel() {
			return jobmodel;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public void setJobmodel(List<JobModel> jobmodel) {
			this.jobmodel = jobmodel;
//			 for(JobModel b : jobmodel) {
//		            b.setOrganization(this);
//		        }
		}
		
		public OrganizationModel() {
			super();
		}

		@Override
		public String toString() {
			return "OrganizationModel [Id=" + Id + ", jobmodel=" + jobmodel + ", orgName=" + orgName
					+ ", orgDescription=" + orgDescription + "]";
		}

		public OrganizationModel(Long id, List<JobModel> jobmodel, String orgName, String orgDescription) {
			super();
			Id = id;
			this.jobmodel = jobmodel;
			this.orgName = orgName;
			this.orgDescription = orgDescription;
		}
		

		
	
		
}