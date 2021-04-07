package tn.webdev.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.webdev.formation.entities.SessionFormation;

@Repository
public interface SessionFormationRepository extends JpaRepository<SessionFormation, Long> {
    
}
