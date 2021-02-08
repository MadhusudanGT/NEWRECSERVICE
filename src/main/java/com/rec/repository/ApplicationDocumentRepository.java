package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicationDocumentModel;
@Repository
public interface ApplicationDocumentRepository extends JpaRepository<ApplicationDocumentModel, Long>{

}
