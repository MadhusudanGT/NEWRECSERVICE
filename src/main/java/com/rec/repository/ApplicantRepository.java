package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicantModel;
@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantModel, Long> {

}
