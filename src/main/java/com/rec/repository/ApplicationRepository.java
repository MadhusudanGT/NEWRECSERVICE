package com.rec.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;


public interface ApplicationRepository extends JpaRepository<ApplicationModel,Long> {

	Optional<ApplicationModel> findById(Long id);
	
}
