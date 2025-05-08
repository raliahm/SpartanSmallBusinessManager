package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.BadWord;
import com.csc340.spartan_manager.administration_portal.Repository.BadWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadWordService {
    @Autowired
    private BadWordRepository badWordRepository;

    @Autowired
    private EntityUpdateEntryService updateLogger;

    public List<BadWord> getAllBadWords() {
        return badWordRepository.findAll();
    }


    public BadWord addBadWord(BadWord badWord) {
        updateLogger.logUpdate(badWord.getId(), "INSERT", "bad-words", null, null, badWord.getWord(), "Added bad word");

        return badWordRepository.save(badWord);
    }

    public void deleteBadWord(int id) {
        BadWord existing = badWordRepository.findById(id).orElseThrow();

        updateLogger.logUpdate(id, "DELETE", "bad-words", null, existing.getWord(), null, "Deleted bad word");

        badWordRepository.deleteById(id);
    }

    public BadWord getBadWord(int id) {
        return badWordRepository.findById(id).get();
    }

    public BadWord updateBadWord(int id, BadWord badWord) {
        BadWord existing = badWordRepository.findById(id).orElseThrow();
        String oldWord = existing.getWord();
        existing.setWord(badWord.getWord());
        updateLogger.logUpdate(id, "UPDATE", "bad-words", "word", oldWord, existing.getWord(),"Updated bad word");

        return badWordRepository.save(existing);
    }


}
