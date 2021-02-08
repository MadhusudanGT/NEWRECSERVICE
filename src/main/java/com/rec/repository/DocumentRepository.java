package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.DocumentModel;
@Repository
public interface DocumentRepository extends JpaRepository<DocumentModel, Long>{

}
