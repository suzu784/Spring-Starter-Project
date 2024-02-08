package com.example.SpringStarterProject.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringStarterProject.model.Item;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

/**
 * ShoppingCartController
 * ショッピングカートのコントローラクラス.
 * 
 * @author suzuki
 */
@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
  @Autowired
  private HttpSession session;
  @Autowired
  private ServletContext application;

  @GetMapping({ "", "/" })
  public String index(Model model) {
    if (application.getAttribute("itemList") == null) {
      List<Item> itemList = new LinkedList<>();
      itemList.add(new Item("手帳ノート", 1000));
      itemList.add(new Item("文房具セット", 1500));
      itemList.add(new Item("ファイル", 2000));
      application.setAttribute("itemList", itemList);
    }

    int total = 0;
    model.addAttribute("total", total);
    if (session.getAttribute("cartItems") == null) {
      List<Item> cartItems = new LinkedList<>();
      session.setAttribute("cartItems", cartItems);
    } else {
      List<Item> itemList = (List<Item>) session.getAttribute("cartItems");
      for (Item item : itemList) {
        total += item.getPrice();
      }
      model.addAttribute("total", total);
    }

    return "item-and-cart";
  }

  @PostMapping({ "/in-cart", "/in-cart/" })
  public String inCart(Integer item_index) {
    LinkedList<Item> itemList = (LinkedList<Item>) application.getAttribute("itemList");
    Item item = itemList.get(item_index);
    LinkedList<Item> cartItems = (LinkedList<Item>) session.getAttribute("cartItems");
    cartItems.add(item);
    session.setAttribute("cartItems", cartItems);
    return "redirect:/exam06";
  }

  @PostMapping({"/delete", "/delete/"})
  public String delete(Integer item_index) {
    LinkedList<Item> cartItems = (LinkedList<Item>) session.getAttribute("cartItems");
    cartItems.remove(cartItems.get(item_index));
    session.setAttribute("cartItems", cartItems);
    return "redirect:/exam06";
  }
}
