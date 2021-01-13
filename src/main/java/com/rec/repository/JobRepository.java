package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.JobModel;

public interface JobRepository extends JpaRepository<JobModel,Long> {
	Optional<JobModel> findById(Long id);
}
