package com.rec.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.AnswersModel;
import com.rec.model.InterviewModel;
@Repository
public interface InterviewRepo extends JpaRepository<InterviewModel, Long>{

}