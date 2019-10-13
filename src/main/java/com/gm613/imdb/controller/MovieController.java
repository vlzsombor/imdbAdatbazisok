package com.gm613.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gm613.imdb.repository.MovieRepository;

@Controller
@RequestMapping("/movies/")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String showSignUpForm(Model model) {
	System.out.println(movieRepository.findAll());
	model.addAttribute("movies", movieRepository.findAll());
	return "index";
    }
}
