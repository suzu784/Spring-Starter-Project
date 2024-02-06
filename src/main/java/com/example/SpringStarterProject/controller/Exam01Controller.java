package com.example.SpringStarterProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Exam01Controller
 */
@Controller
@RequestMapping("/exam01")
public class Exam01Controller {

  @GetMapping("")
  public String index() {
    return "exam01";
  }

  @PostMapping("/submit")
  public String submit(Model model, String name) {
    model.addAttribute("name", name);
    return "exam01-result";
  }
}
