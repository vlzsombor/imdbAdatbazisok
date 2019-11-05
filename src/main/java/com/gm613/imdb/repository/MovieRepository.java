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

    @Query(value = "select actors.first_name, actors.last_name, Count(movies.title) as countTitles\r\n"
	    + "from actors\r\n" + "inner join szereplesek on actors.id = szereplesek.actorsId\r\n"
	    + "inner join movies on movies.id = szereplesek.moviesId\r\n" + "group by actors.first_name\r\n"
	    + "order by countTitles desc\r\n"

	    , nativeQuery = true)
    List<List<String>> countActorsInMovies();

    @Query(value = "select actors.first_name, actors.last_name \r\n" + 
    	"from actors \r\n" + 
    	"where actors.gender = ?",
	    nativeQuery = true)
    List<List<String>> showByGender(String gender);

    

}
