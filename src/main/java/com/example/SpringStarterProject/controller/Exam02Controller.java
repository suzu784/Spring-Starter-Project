package com.example.SpringStarterProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

/**
 * Exam02Controller
 */
@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
  @Autowired
  private ServletContext application;

  @GetMapping("")
  public String index() {
    return "exam02";
  }

  @PostMapping("/add")
  public String add(int num1, int num2) {
    application.setAttribute("num1", num1);
    application.setAttribute("num2", num2);
    int result = num1 + num2;
    application.setAttribute("result", result);
    return "exam02-result";
  }

  @GetMapping("/result")
  public String result() {
    return "exam02-result2";
  }
}
