package com.SpartanSmallBusinessManager.API.event;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByProvider(Provider provider);
}
