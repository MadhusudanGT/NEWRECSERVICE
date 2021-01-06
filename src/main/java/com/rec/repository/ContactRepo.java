package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.ContactModel;
import com.rec.model.UserModel;

public interface ContactRepo extends JpaRepository<ContactModel, Long>{
	Optional<ContactModel> findById(Long id);
}
