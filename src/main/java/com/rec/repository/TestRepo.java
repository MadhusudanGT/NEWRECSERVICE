package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.TestModel;
@Repository
public interface TestRepo extends JpaRepository<TestModel, Long> {

}