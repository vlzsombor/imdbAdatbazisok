package com.gm613.imdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
    @GetMapping("/")
    public String showSignUpForm(Model model) {
	return "redirect:/movies/";
    }
}
