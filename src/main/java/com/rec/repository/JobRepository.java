package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.JobModel;
@Repository
public interface JobRepository extends JpaRepository<JobModel,Long> {
	
}
