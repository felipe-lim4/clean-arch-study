package com.cleanarq.project.infra.persistence.repository;

import com.cleanarq.project.infra.persistence.Entity.DocumentJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentJpaRepository extends JpaRepository<DocumentJpa, UUID> {

    
}
