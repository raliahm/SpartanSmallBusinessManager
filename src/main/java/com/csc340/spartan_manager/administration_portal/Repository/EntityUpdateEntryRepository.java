package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.EntityUpdateEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityUpdateEntryRepository extends JpaRepository<EntityUpdateEntry, Integer> {
}
