package com.gm613.imdb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Column(name = "title")
    private String title;
    @NotNull
    @Column(name = "genre")
    private String genre;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER )
    @JoinColumn(name = "studio_id", referencedColumnName = "id")
    private Studio studio;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "plays", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
	    @JoinColumn(name = "actor_id") })
    private List<Actor> actors = new ArrayList<>();

}
