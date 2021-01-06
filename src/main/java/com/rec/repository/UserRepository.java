package com.rec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rec.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findById(Long id);
}
