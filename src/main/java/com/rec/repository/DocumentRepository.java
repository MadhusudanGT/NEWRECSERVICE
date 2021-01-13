package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rec.model.DocumentModel;

public interface DocumentRepository extends JpaRepository<DocumentModel,Long> {
	Optional<DocumentModel> findById(Long id);
}
