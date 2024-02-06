package com.example.SpringStarterProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.form.UserForm;

import jakarta.servlet.ServletContext;

/**
 * Exam04Controller
 */
@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
  @Autowired
  private ServletContext application;

  @GetMapping("")
  public String index(UserForm form) {
    return "exam04";
  }

  @PostMapping("/register")
  public String register(@Validated UserForm userForm, BindingResult result) {
    if (result.hasErrors()) {
      return index(userForm);
    }
    application.setAttribute("name", userForm.getName());
    application.setAttribute("age", userForm.getAge());
    application.setAttribute("comment", userForm.getComment());
    return "exam04-result";
  }
}
