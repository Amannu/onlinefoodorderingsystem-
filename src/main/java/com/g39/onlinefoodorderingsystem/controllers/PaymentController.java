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
import com.g39.onlinefoodorderingsystem.domains.Payment;

import com.g39.onlinefoodorderingsystem.services.PaymentService;

@Controller
public class PaymentController {
	private PaymentService paymentService;
	@ModelAttribute(name="payments")
	public Payment payment() {
		return new Payment();
	}
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	@GetMapping("/payment")
    public String showAddingForm(Menu menu,Model model) {
		model.addAttribute("payments", paymentService.findAll());
        return "redirect:/order";
    }
	@PostMapping("/addpayment")
    public String addOrder(@Valid Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "order";
        }
        paymentService.save(payment());
        model.addAttribute("payments", paymentService.findAll());
        return "payment";
    }
	@PostMapping("/updatepayment/{id}")
	public String updateMenu(@PathVariable("id") long id, @Valid Payment payment, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	payment.setId(id);
	        return "payment";
	    }
	         
	    paymentService.save(payment);
	    model.addAttribute("payments", paymentService.findAll());
	    return "payment";
	}
	@RequestMapping("/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") long id, Model model) {
		Payment payment =paymentService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
	    paymentService.delete(payment);
	    model.addAttribute("menus", paymentService.findAll());
	    return "redirect:/payment";
	}
}
