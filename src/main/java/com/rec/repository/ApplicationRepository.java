package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.ApplicationModel;
@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationModel, Long> {

}
