package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.OrganizationModel;
@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationModel, Long> {

}