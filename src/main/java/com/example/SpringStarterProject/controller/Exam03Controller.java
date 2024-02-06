package com.example.SpringStarterProject.controller;

import java.text.NumberFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;

/**
 * Exam03Controller
 */
@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
  @Autowired
  private ServletContext application;

  @GetMapping("")
  public String index() {
    return "exam03";
  }

  @PostMapping("/purchase")
  public String purchase(int item1, int item2, int item3) {
    int priceExcludingTax = item1 + item2 + item3;
    String formattedPriceExcludingTax = String.format("%,d", priceExcludingTax);
    int priceIncludingTax =  (int)(priceExcludingTax * 1.1);
    String formattedPriceIncludingTax = String.format("%, d", priceIncludingTax);
    application.setAttribute("formattedPriceExcludingTax", formattedPriceExcludingTax);
    application.setAttribute("formattedPriceIncludingTax", formattedPriceIncludingTax);
    return "exam03-result";
  }
}
