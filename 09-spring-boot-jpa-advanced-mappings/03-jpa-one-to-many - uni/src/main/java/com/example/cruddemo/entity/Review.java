package com.example.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    // define fields and annotate fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    // create constructors
    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    // create getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // define toString method
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
