package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.ApplicationDocumentModel;

public interface ApplicationDocumentRepository extends JpaRepository<ApplicationDocumentModel,Long> {
	Optional<ApplicationDocumentModel> findById(Long id);
}
