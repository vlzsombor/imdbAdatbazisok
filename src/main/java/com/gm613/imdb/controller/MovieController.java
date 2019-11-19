package com.gm613.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	System.out.println(actorRepository.findAll());
	System.out.println(movieRepository.findAll());
//	actorRepository.findAll().stream().forEach(t -> System.out.println(t.getMovies()));
	return "index";
    }

    @GetMapping("/countStudiosMovies")
    public String countStudiosMovies(Model model) {
	model.addAttribute("queries", movieRepository.countStudiosMovies());
	System.out.println(movieRepository.countStudiosMovies());
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
	System.out.println(movieRepository.showByGender("Male"));
	return "showByGender";
    }

}
