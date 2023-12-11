package com.example.coursemanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Lesson> lessons;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private User lecturer;

    public Block(String name) {
        this.name = name;
    }
}
