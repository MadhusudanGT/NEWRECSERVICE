package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.ApplicantModel;
import com.rec.model.UserModel;


public interface ApplicantRepository extends JpaRepository<ApplicantModel,Long> {
	Optional<ApplicantModel> findById(Long id);
}
