package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.RegistrationModel;
@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long> {

}
