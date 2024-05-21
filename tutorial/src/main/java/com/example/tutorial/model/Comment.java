package com.example.tutorial.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "comments")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tutorial_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Tutorial"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties(value = {"comments", "hibernateLazyInitializer"}, allowSetters = true)
    // @JsonIgnore
    // @JsonManagedReference
    private Tutorial tutorial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}