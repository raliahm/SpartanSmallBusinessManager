package com.SpartanSmallBusinessManager.API.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Statistics getStatisticsById(int statsId) {
        return statisticsRepository.findById(statsId).orElse(null);
    }

    public void addNewStatistics(Statistics statistics) {
        statisticsRepository.save(statistics);
    }

    public void updateStatistics(int statsId, Statistics updatedStats) {
        Statistics existing = getStatisticsById(statsId);
        if (existing != null) {
            existing.setTotalSales(updatedStats.getTotalSales());
            existing.setTotalReviews(updatedStats.getTotalReviews());
            statisticsRepository.save(existing);
        }
    }

    public void deleteStatisticsById(int statsId) {
        statisticsRepository.deleteById(statsId);
    }
}
