package pl.edu.agh.ki.mwo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.model.Author;
import pl.edu.agh.ki.mwo.persistence.ConferenceDatabase;

@Controller
public class ReviewersController {

    @RequestMapping(value="/Reviewers")
    public String listReviewesr(Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	model.addAttribute("reviewers", ConferenceDatabase.getInstance().getReviewers());
    	
        return "reviewersList"; 
    }
    
    @RequestMapping(value="/SelectedReviewers")
    public String listSelectedReviewers(Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	model.addAttribute("reviewers", ConferenceDatabase.getInstance().getSelectedReviewers());
    	
        return "selectedReviewersList"; 
    }

}