package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.JobPlatform;
@Repository
public interface JobPlatformRepository extends JpaRepository<JobPlatform, Long> {


}