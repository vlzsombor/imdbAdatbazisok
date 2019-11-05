package com.gm613.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm613.imdb.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long>{

}
