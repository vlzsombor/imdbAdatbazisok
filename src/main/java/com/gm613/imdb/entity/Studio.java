package com.gm613.imdb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "studios")
public class Studio implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;
    
    /*@OneToMany(cascade = CascadeType.ALL,
	    mappedBy = "studio",
	    orphanRemoval = true)
    private List<Movie> movie;*/
}
