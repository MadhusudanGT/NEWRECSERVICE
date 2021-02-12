package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicantModel;
import com.rec.model.ApplicationModel;
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationModel, Long> {


	@Query("select u from ApplicationModel u where u.EmailID=:email")
	ApplicationModel findByEmailId(String email);

}
