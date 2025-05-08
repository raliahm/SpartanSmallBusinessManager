package com.SpartanSmallBusinessManager.customer_crud_api.Events;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
}
