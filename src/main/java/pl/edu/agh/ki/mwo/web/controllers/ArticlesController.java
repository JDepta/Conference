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
public class ArticlesController {

    @RequestMapping(value="/Articles")
    public String listArticles(Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	model.addAttribute("articles", ConferenceDatabase.getInstance().getArticles());
    	
        return "articlesList";    
    }
    
    @RequestMapping(value="/ArticlesAuthor")
    public String listArticlesAuthorView(@RequestParam(value="authorId") int authorId,
    		Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	model.addAttribute("articles", ConferenceDatabase.getInstance().getArticlesAuthorView(authorId));
    	
        return "articlesListAuthorView";
    }
    
  
    @RequestMapping(value="/AddArticle")
    public String displayAddStudentForm(Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
        return "articleForm";    
    }
    

    
    @RequestMapping(value="/CreateArticle", method=RequestMethod.POST)
    public String addArticle(
    		@RequestParam(value="articleTitle") String title,
    		@RequestParam(value="articleSubject") String subject,
    		Model model, HttpSession session) 
    {    	
    	if (session.getAttribute("userLogin") == null)
    		return "redirect:/Login";
    	
    	long authorId=1; //tu powinno sczytac id autora, który się zalogowal (domyslnie zakladam, ze 1)
    	ConferenceDatabase.getInstance().addArticle(title, subject);    	
    	model.addAttribute("articles", ConferenceDatabase.getInstance().getArticlesAuthorView(authorId));
    	model.addAttribute("message", "Nowy artykuł został dodany");
         	
    	return "articlesListAuthorView";    
    }


}