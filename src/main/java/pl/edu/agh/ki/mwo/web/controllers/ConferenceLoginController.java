package pl.edu.agh.ki.mwo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConferenceLoginController {

	 @RequestMapping(value={"/", "/Login"}, method=RequestMethod.GET)
	 public String displayLoginForm() {
	        return "loginForm";
	    }

    @RequestMapping(value="/Login", method=RequestMethod.POST)
    public String doLogin(@RequestParam(value="login") String login, 
    		@RequestParam(value="password") String password,
    		Model model,
    		HttpSession session) {
    	
        if (login.equals("Admin"))
        {
        	session.setAttribute("userLogin", login);
        	return "redirect:/Welcome";
        }
        
        else if (login.equals("Author"))
        {
        	session.setAttribute("userLogin", login);
        	return "redirect:/WelcomeAuthor";
        }
        
        else if (login.equals("Reviewer"))
        {
        	session.setAttribute("userLogin", login);
        	return "redirect:/WelcomeReviewer";
        }
        
        else
        {
        	session.removeAttribute("userLogin");
        	return "redirect:/Login";
        }
    }

    @RequestMapping(value="/Logout")
    public String doLogout( HttpSession session) {
    	session.removeAttribute("userLogin");
        return "loginForm";
    }

    @RequestMapping(value="/Welcome")
    public String welcome(Model model, HttpSession session) {
        return "welcomeConference";
    }
    
    @RequestMapping(value="/WelcomeAuthor")
    public String welcomeAuthor(Model model, HttpSession session) {
        return "welcomeConferenceAuthorView";
    }
    
    @RequestMapping(value="/WelcomeReviewer")
    public String welcomeReviewer(Model model, HttpSession session) {
        return "welcomeConferenceReviewerView";
    }

}