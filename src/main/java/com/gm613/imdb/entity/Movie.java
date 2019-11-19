package com.gm613.imdb.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.ToString;

@ToString
@Entity
@Getter
@Table(name = "movies")
public class Movie implements Serializable{
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_id", referencedColumnName = "id")
    private Studio studio;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "plays", 
    joinColumns = { @JoinColumn(name = "movie_id") },
    inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    Set<Actor> actors = new HashSet<>();
//    @ManyToMany
//    @JoinColumn(name="id")
//    List<Actor> actors = new ArrayList<>();
}
