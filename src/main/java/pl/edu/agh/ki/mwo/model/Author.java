package pl.edu.agh.ki.mwo.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends User {
	
	private List<Article> articles = new ArrayList<Article>();

	public Author(String name, String surname, String login, String password, String email, String university) {
		super(name, surname, login, password, email, university);
	}

	public Article createArticle(String title){
		return new Article();
	}
	
	
	public List<Article> getArticles() {
		return articles;
	}

	/*
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	*/

	
	public void addArticle(Article article){	
		articles.add(article);
	}
	

}
