package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.JobPosition;
@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

}