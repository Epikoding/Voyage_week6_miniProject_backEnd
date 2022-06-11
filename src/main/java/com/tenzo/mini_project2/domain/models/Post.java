package com.tenzo.mini_project2.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
