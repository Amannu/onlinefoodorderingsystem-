package com.g39.onlinefoodorderingsystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g39.onlinefoodorderingsystem.domains.Feedback;
import com.g39.onlinefoodorderingsystem.services.FeedbackService;



public class FeedbackController {
	private FeedbackService feedbackService;
	@ModelAttribute(name="feedbacks")
	public Feedback feedback() {
		return new Feedback();
	}
	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	@GetMapping("/feedback")
    public String showAddingForm(Feedback feedback,Model model) {
		model.addAttribute("feedbacks", feedbackService.findAll());
        return "redirect:/feedback";
    }
	@PostMapping("/addfeedback")
    public String addOrder(@Valid Feedback feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "feedback";
        }
        feedbackService.save(feedback);
        model.addAttribute("feedbacks", feedbackService.findAll());
        return "feedback";
    }
	@PostMapping("/updatefeedback/{id}")
	public String updateFeedback(@PathVariable("id") long id, @Valid Feedback feedback, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	feedback.setId(id);
	        return "feedback";
	    }
	         
	    feedbackService.save(feedback);
	    model.addAttribute("feedbacks", feedbackService.findAll());
	    return "feedback";
	}
	@RequestMapping("/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") long id, Model model) {
	    Feedback feedback =feedbackService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
	    feedbackService.delete(feedback);
	    model.addAttribute("feedbacks", feedbackService.findAll());
	    return "redirect:/feedback";
	}
}
