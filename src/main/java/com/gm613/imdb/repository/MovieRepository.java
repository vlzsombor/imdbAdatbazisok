package com.gm613.imdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gm613.imdb.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "select studios.name,count(movies.title) as moviesTitleNumber " + "from movies "
	    + "join studios on studios.id = movies.studio_id " + "group by studio_id "
	    + "order by moviesTitleNumber", nativeQuery = true)
    List<List<String>> countStudiosMovies();

    @Query(value = "select actors.first_name, actors.last_name, Count(movies.title) as countTitles \r\n" + 
    	"from actors inner join plays on actors.actor_id = plays.actors_id \r\n" + 
    	"inner join movies on movies.movie_id = plays.movies_id\r\n" + 
    	"group by actors.first_name  \r\n" + 
    	"order by countTitles desc",
    	nativeQuery = true)
    List<List<String>> countActorsInMovies();

    @Query(value = "select actors.first_name, actors.last_name" + 
    	"from actors" + 
    	"where actors.gender = ?",
	    nativeQuery = true)
    List<List<String>> showByGender(String gender);

}
