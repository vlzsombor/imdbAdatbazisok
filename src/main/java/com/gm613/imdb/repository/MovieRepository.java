package com.gm613.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm613.imdb.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
