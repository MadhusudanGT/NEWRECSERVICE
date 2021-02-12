package com.rec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.rec.model.RegistrationModel;
import com.rec.model.UserModel;
@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long> {

	@Query("select u from RegistrationModel u where u.Email=:email")
	RegistrationModel findByEmailId(String email);


}
