package com.csc340.spartan_manager.administration_portal.Repository;
import com.csc340.spartan_manager.administration_portal.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}