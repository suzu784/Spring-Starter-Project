package com.example.SpringStarterProject.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

/**
 * ShoppingCartController
 */
@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
  @Autowired
  private HttpSession session;
  @Autowired
  private ServletContext application;

  @GetMapping("")
  public String index(Model model) {
    // if (application.getAttribute("itemList") == null) {
      List<Item> itemList = new LinkedList<>();
      itemList.add(new Item("手帳ノート", 1000));
      itemList.add(new Item("文房具セット", 1500));
      itemList.add(new Item("ファイル", 2000));
      application.setAttribute("itemList", itemList);
    // }

    List<Item> cartItems = new ArrayList<>();
    session.setAttribute("cartItems", cartItems);
    int total = 0;
    model.addAttribute("total", total);
    return "item-and-cart";
  }

  @GetMapping("/in-cart")
  public String inCart() {
    Object itemList = application.getAttribute("itemList");

    if (itemList instanceof List) {
      List<Item> itemListAsList = (List<Item>) itemList;
      for (int i = 0; i < itemListAsList.size(); i++) {
        Item item = itemListAsList.get(i);
        System.out.println(item);
      }
    }
    session.setAttribute("cartItems", itemList);
    return "item-and-cart";
  }

  @GetMapping("/delete")
  public String delete() {
    // Object cartItems = session.getAttribute("cartItems");
    session.removeAttribute("cartItems");
    return "item-and-cart";
  }
}
