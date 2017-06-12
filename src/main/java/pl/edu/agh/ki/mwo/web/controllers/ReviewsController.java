package pl.edu.agh.ki.mwo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.ki.mwo.model.Article;
import pl.edu.agh.ki.mwo.persistence.ConferenceDatabase;

@Controller
public class ReviewsController {

    @RequestMapping(value="/Reviews")
    public String listArticles(Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	model.addAttribute("reviews", ConferenceDatabase.getInstance().getReviews());
    	
        return "reviewsList";    
    }
    


}