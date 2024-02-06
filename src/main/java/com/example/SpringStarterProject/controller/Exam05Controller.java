package com.example.SpringStarterProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.model.Member;
import com.example.SpringStarterProject.repository.MemberRepository;

/**
 * Exam05Controller
 */
@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
  @Autowired
  private MemberRepository memberRepository;

  @GetMapping("")
  public String index() {
    return "exam05";
  }

  @GetMapping("/search")
  public String search(Model model, String name) {
    List<Member> memberList =  memberRepository.search(name);
    model.addAttribute("memberList", memberList);
    return "exam05-result";
  }
}
