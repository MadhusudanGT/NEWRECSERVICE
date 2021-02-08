package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicationEvaluation;
@Repository
public interface ApplicationEvaluationRepository extends JpaRepository<ApplicationEvaluation, Long> {

}
