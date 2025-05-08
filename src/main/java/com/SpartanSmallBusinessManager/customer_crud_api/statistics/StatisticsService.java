package com.SpartanSmallBusinessManager.API.statistics;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public Statistics getStatsForProvider(Provider provider) {
        return statisticsRepository.findByProvider(provider);
    }

    public void saveOrUpdateStatistics(Statistics stats) {
        Statistics existing = statisticsRepository.findByProvider(stats.getProvider());
        if (existing != null) {
            existing.setTotalSales(stats.getTotalSales());
            existing.setTotalReviews(stats.getTotalReviews());
            statisticsRepository.save(existing);
        } else {
            statisticsRepository.save(stats);
        }
    }
}
