package com.g39.onlinefoodorderingsystem.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.g39.onlinefoodorderingsystem.domains.Menu;
import com.g39.onlinefoodorderingsystem.security.User;
import com.g39.onlinefoodorderingsystem.services.MenuService;

@Controller
public class MenuController {
	private MenuService menuService;
	@ModelAttribute(name="menus")
	public Menu menu() {
		return new Menu();
	}
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	@GetMapping("/admin-page")
    public String showAddingForm(Menu menu,Model model) {
		model.addAttribute("menus", menuService.findAll());
        return "admin-page";
    }
	@PostMapping("/addmenu")
    public String addUser(@Valid Menu menu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin-page";
        }
        menuService.save(menu);
        model.addAttribute("menus", menuService.findAll());
        return "admin-page";
    }
	@PostMapping("/update/{id}")
	public String updateMenu(@PathVariable("id") long id, @Valid Menu menu, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        menu.setId(id);
	        return "admin-page";
	    }
	         
	    menuService.save(menu);
	    model.addAttribute("menus", menuService.findAll());
	    return "admin-page";
	}
	@RequestMapping("/delete/{id}")
	public String deleteMenu(@PathVariable("id") long id, Model model) {
	    Menu menu = menuService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid menu Id:" + id));
	    menuService.delete(menu);
	    model.addAttribute("menus", menuService.findAll());
	    return "redirect:/admin-page";
	}
	
	
    
}
	
	
	

