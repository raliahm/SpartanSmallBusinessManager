package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.Entity.BadWord;
import com.csc340.spartan_manager.administration_portal.Service.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bad-words")
public class BadWordController {

    @Autowired
    private BadWordService badWordService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllBadWords() {
        List<BadWord> badWords = badWordService.getAllBadWords();
        return new ResponseEntity<>(badWords, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getBadWordById(@PathVariable int id) {
        return new ResponseEntity<>(badWordService.getBadWord(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> addBadWord(@RequestBody BadWord badWord) {
        BadWord saved = badWordService.addBadWord(badWord);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBadWord(@PathVariable int id) {
        badWordService.deleteBadWord(id);
        return new ResponseEntity<>("Bad word deleted successfully", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBadWord(@PathVariable int id, @RequestBody BadWord badWord) {
        BadWord updated = badWordService.updateBadWord(id, badWord);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
