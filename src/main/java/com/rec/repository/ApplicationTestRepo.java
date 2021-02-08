package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicationTestModel;
@Repository
public interface ApplicationTestRepo extends JpaRepository<ApplicationTestModel, Long>{

}