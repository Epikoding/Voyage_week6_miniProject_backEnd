package com.tenzo.mini_project2.domain.models;

import lombok.*;

import javax.persistence.*;

@Entity(name = "tagInfo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tags {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "tagName")
    private String tag;

    public Tags(String tag) {
        this.tag = tag;
    }
}
