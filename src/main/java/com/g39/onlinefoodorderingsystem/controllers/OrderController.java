package com.g39.onlinefoodorderingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g39.onlinefoodorderingsystem.domains.Menu;
import com.g39.onlinefoodorderingsystem.domains.Order;
import com.g39.onlinefoodorderingsystem.services.OrderService;

@Controller
public class OrderController {
	private OrderService orderService;
	@ModelAttribute(name="orders")
	public Order order() {
		return new Order();
	}
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	@GetMapping("/order")
    public String showAddingForm(Menu menu,Model model) {
		model.addAttribute("orderss", orderService.findAll());
        return "redirect:/order";
    }
	@PostMapping("/addorder")
    public String addOrder(@Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "order";
        }
        orderService.save(order);
        model.addAttribute("orders", orderService.findAll());
        return "order";
    }
	@PostMapping("/updateorder/{id}")
	public String updateMenu(@PathVariable("id") long id, @Valid Order order, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        order.setId(id);
	        return "order";
	    }
	         
	    orderService.save(order);
	    model.addAttribute("orders", orderService.findAll());
	    return "order";
	}
	@RequestMapping("/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") long id, Model model) {
	    Order order =orderService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
	    orderService.delete(order);
	    model.addAttribute("menus", orderService.findAll());
	    return "redirect:/order";
	}

}
