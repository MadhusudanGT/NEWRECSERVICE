package com.rec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rec.model.Recruiters;

@Repository
public interface RecuiterRepository extends JpaRepository<Recruiters, Long> {

}
