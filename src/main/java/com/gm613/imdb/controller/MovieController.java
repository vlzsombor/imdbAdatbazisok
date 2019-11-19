package com.gm613.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gm613.imdb.entity.Movie;
import com.gm613.imdb.repository.ActorRepository;
import com.gm613.imdb.repository.MovieRepository;
import com.gm613.imdb.repository.StudiosRepository;

@Controller
@RequestMapping("/movies/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private StudiosRepository studioRepository;

    @GetMapping("/")
    public String showSignUpForm(Model model) {
	model.addAttribute("movies", movieRepository.findAll());
	return "index";
    }

    @GetMapping("/countStudiosMovies")
    public String countStudiosMovies(Model model) {
	model.addAttribute("queries", movieRepository.countStudiosMovies());
	return "countStudiosMovies";
    }

    @GetMapping("/countActorsInMovies")
    public String countActorsInMovies(Model model) {
	model.addAttribute("queries", movieRepository.countActorsInMovies());
	return "countActorsInMovies";
    }

    @GetMapping("/showByGender")
    public String showByGender(Model model) {
	model.addAttribute("queries", movieRepository.showByGender("Female"));
	return "showByGender";
    }
    
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	Movie movie = movieRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Invalid movie id:" + id));
	model.addAttribute("movie", movie);
	return "update";
    }
    
    
    

}
