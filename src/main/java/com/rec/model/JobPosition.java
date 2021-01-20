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
	@Table(name="jobPosition")
	public class JobPosition {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long Id;
		
		@OneToMany(targetEntity =JobModel.class,mappedBy = "jobPosition", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
		@JsonIgnore
	    private List<JobModel> jobmodel=new ArrayList<>();

		@Column(name="name")
		private String name;
		
		@Column(name="description")
		private String description;
		
		@Column(name="JobCategory")
		private String JobCategory;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}


		public List<JobModel> getJobmodel() {
			return jobmodel;
		}

		public void setJobmodel(List<JobModel> jobmodel) {
			this.jobmodel = jobmodel;
//			  for(JobModel b : jobmodel) {
//		            b.setJobPosition(this);
//		        }
		}

		
		@Override
		public String toString() {
			return "JobPosition [Id=" + Id + ", jobmodel=" + jobmodel + ", name=" + name + ", description="
					+ description + ", JobCategory=" + JobCategory + "]";
		}

		public JobPosition(Long id, List<JobModel> jobmodel, String name, String description, String jobCategory) {
			super();
			Id = id;
			this.jobmodel = jobmodel;
			this.name = name;
			this.description = description;
			JobCategory = jobCategory;
		}

		public String getJobCategory() {
			return JobCategory;
		}

		public void setJobCategory(String jobCategory) {
			JobCategory = jobCategory;
		}

		public JobPosition() {
			super();
			}
		
		
		
}