package com.csc340.spartan_manager.administration_portal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bad-words")

public class BadWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String word;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
