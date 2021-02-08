package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long>{

	

}
