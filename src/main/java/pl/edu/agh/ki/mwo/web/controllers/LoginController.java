/*package pl.edu.agh.ki.mwo.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	 @RequestMapping(value={"/", "/Login"}, method=RequestMethod.GET)
	 public String displayLoginForm() {
	        return "loginForm";
	    }

    @RequestMapping(value="/Login", method=RequestMethod.POST)
    public String doLogin(@RequestParam(value="login") String login, 
    		@RequestParam(value="password") String password,
    		Model model,
    		HttpSession session) {
        if (login.equals(password))
        {
        	session.setAttribute("userLogin", login);
        	return "redirect:/Welcome";
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
        return "welcome";
    }

}
*/