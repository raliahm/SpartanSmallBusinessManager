package com.SpartanSmallBusinessManager.API.statistics;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    Statistics findByProvider(Provider provider);
}
