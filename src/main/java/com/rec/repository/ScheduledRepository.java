package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.SchedulesApplication;
@Repository
public interface ScheduledRepository extends JpaRepository<SchedulesApplication,Long>{

}
