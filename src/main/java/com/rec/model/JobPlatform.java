package com.rec.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.ForeignKey;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(name="jobPlatform")
	public class JobPlatform {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long Id;
		
		
		 @OneToMany(targetEntity =JobModel.class,mappedBy = "jobPlatform", cascade = {CascadeType.ALL})
		 @JsonIgnore
		    private List<JobModel> jobmodel=new ArrayList<>();
		
		@Column(name="platformName")
		private String platformName;
		
		@Column(name="platformDescription")
		private String platformDescription;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}


		public String getPlatformName() {
			return platformName;
		}

		public void setPlatformName(String platformName) {
			this.platformName = platformName;
		}

		public String getPlatformDescription() {
			return platformDescription;
		}

		public void setPlatformDescription(String platformDescription) {
			this.platformDescription = platformDescription;
		}


		@Override
		public String toString() {
			return "JobPlatform [Id=" + Id + ", jobmodel=" + jobmodel + ", platformName=" + platformName
					+ ", platformDescription=" + platformDescription + "]";
		}

		public List<JobModel> getJobmodel() {
			return jobmodel;
		}

		public void setJobmodel(List<JobModel> jobmodel) {
			this.jobmodel = jobmodel;
//			 for(JobModel b : jobmodel) {
//		            b.setJobPlatform(this);
//		        }
		}
		
		public JobPlatform() {
			super();
		}

		public JobPlatform(Long id, List<JobModel> jobmodel, String platformName, String platformDescription) {
			super();
			Id = id;
			this.jobmodel = jobmodel;
			this.platformName = platformName;
			this.platformDescription = platformDescription;
		}


		
		
		}