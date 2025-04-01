package com.SpartanSmallBusinessManager.API.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * StatisticsController.java.
 * Includes all REST API endpoint mappings for the Statistics object.
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService service;

    /**
     * Get a list of all Statistics in the database.
     * http://localhost:8080/statistics/all
     *
     * @return a list of Statistics objects.
     */
    @GetMapping("/all")
    public Object getAllStatistics() {
        return new ResponseEntity<>(service.getAllStatistics(), HttpStatus.OK);
    }

    /**
     * Create a new Statistics entry.
     * http://localhost:8080/statistics/new
     *
     * @param statistics the new Statistics object.
     * @return success message.
     */
    @PostMapping("/new")
    public Object addNewStatistics(@RequestBody Statistics statistics) {
        service.addNewStatistics(statistics);
        return new ResponseEntity<>("New Statistics Successfully Created!", HttpStatus.CREATED);
    }

    /**
     * Update an existing Statistics object.
     * http://localhost:8080/statistics/update/2
     *
     * @param statsId the unique Statistics Id.
     * @param statistics   the updated Statistics details.
     * @return the updated Statistics object.
     */
    @PutMapping("/update/{statsId}")
    public Object updateStatistics(@PathVariable int statsId, @RequestBody Statistics statistics) {
        service.updateStatistics(statsId, statistics);
        return new ResponseEntity<>(service.getStatisticsById(statsId), HttpStatus.CREATED);
    }

    /**
     * Delete a Statistics object.
     * http://localhost:8080/statistics/delete/2
     *
     * @param statsId the unique Statistics Id.
     * @return the updated list of Statistics.
     */
    @DeleteMapping("/delete/{statsId}")
    public Object deleteStatisticsById(@PathVariable int statsId) {
        service.deleteStatisticsById(statsId);
        return new ResponseEntity<>(service.getAllStatistics(), HttpStatus.OK);
    }
}
