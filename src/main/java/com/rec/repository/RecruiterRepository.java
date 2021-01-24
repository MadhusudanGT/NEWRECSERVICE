package com.rec.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.Recruiters;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiters, Long>{

	
	 Recruiters findByfirstName(String fname);

	
	
}