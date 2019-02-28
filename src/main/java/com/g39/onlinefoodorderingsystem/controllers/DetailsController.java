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

import com.g39.onlinefoodorderingsystem.domains.Details;
import com.g39.onlinefoodorderingsystem.services.DetailsService;

@Controller
public class DetailsController {
	private DetailsService detailsService;
	@ModelAttribute(name="details")
	public Details detail() {
		return new Details();
	}
	@Autowired
	public DetailsController(DetailsService detailsService) {
		this.detailsService = detailsService;
	}
	@GetMapping("/detail")
    public String showAddingForm(Details detail,Model model) {
		model.addAttribute("details", detailsService.findAll());
        return "redirect:/detail";
    }
	@PostMapping("/adddetail")
    public String addDetail(@Valid Details detail, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "detail";
        }
        detailsService.save(detail);
        model.addAttribute("details", detailsService.findAll());
        return "detail";
    }
	@PostMapping("/updatedetail/{id}")
	public String updateDetail(@PathVariable("id") long id, @Valid Details detail, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	detail.setId(id);
	        return "detail";
	    }
	         
	    detailsService.save(detail);
	    model.addAttribute("details", detailsService.findAll());
	    return "detail";
	}
	@RequestMapping("/deletedetail/{id}")
	public String deleteDetail(@PathVariable("id") long id, Model model) {
		Details detail =detailsService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
	    detailsService.delete(detail);
	    model.addAttribute("menus", detailsService.findAll());
	    return "redirect:/detail";
	}
}
