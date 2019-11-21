package com.gm613.imdb.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gm613.imdb.entity.Actor;
import com.gm613.imdb.entity.Movie;
import com.gm613.imdb.repository.ActorRepository;
import com.gm613.imdb.repository.MovieRepository;
import com.gm613.imdb.repository.StudiosRepository;

@Controller
@RequestMapping("/movies/")
public class MovieController {

    private Set<Actor> actors = new HashSet<>();

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private StudiosRepository studioRepository;

    @GetMapping("/")
    public String showSignUpForm(Model model) {
	model.addAttribute("movies", movieRepository.findAll());
	actors.clear();
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
	return "update-movie";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, /* @Valid */@ModelAttribute Movie movie, Model model) {
	System.out.println(id);
	//movieRepository.save(movie);
	System.out.println(movie);
	return "index";
    }

    /*
     * @PostMapping("update/test/update}") public String updateTest(String str) { //
     * System.out.println(movie2); // System.out.println(id); //
     * movieRepository.save(movie); System.out.println("\n\n\n\n" + str);
     * //model.addAttribute("movies", movieRepository.findAll()); return "temp"; }
     */

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
	Movie movie = movieRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	movieRepository.delete(movie);
	model.addAttribute("students", movieRepository.findAll());
	return "redirect:/movies/";
    }

    @GetMapping("signup")
    public String showSignUpForm(Model model, Movie movie, Actor actor) {
	movie.setActors(this.actors);
	model.addAttribute("movie", movie);
	return "add-movie";
    }

    @PostMapping("add")
    public String addStudent(@Valid Movie movie, Model model) {
	System.out.println(movie);
	movie.setActors(this.actors);
	movieRepository.save(movie);
	this.actors.clear();
	return "redirect:";
    }

    @GetMapping("add-actor")
    public String addActorGet(Model model, Actor actor) {
	model.addAttribute("actor", actor);
	return "add-actor";
    }

    @PostMapping("add-actor")
    public String addActorPost(Model model, Actor actor) {
	// setCorrectActorId(actor);
	actors.add(actor);
	System.out.println(this.actors);
	// actorRepository.save(actor);
	return "redirect:signup";
    }

}
