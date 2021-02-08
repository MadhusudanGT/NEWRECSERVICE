package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.DbFile;

@Repository
public interface DbfileRepo extends JpaRepository<DbFile, Long>{
	
	
	
}
