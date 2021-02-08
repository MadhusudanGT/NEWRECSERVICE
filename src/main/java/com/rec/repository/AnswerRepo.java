package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.AnswersModel;

public interface AnswerRepo extends JpaRepository<AnswersModel, Long> {

}

