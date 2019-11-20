package com.gm613.imdb.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString 
@Entity
@Table(name = "actors")
public class Actor implements Serializable{
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "first_name")
    private String first_name;
    
    @Column(name = "last_name")
    private String last_name;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "img")
    private String img;
    
    @ManyToMany(mappedBy = "actors",
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude private Set<Movie> movies = new HashSet<>();
}
