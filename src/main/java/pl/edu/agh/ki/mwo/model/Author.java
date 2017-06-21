package pl.edu.agh.ki.mwo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Author extends User {
	
	private Set<Article> articles;

	public Author() {
		super();
		articles = new HashSet<Article>();
	}

	
	public Set<Article> getArticles() {
		return articles;
	}

	
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	

	public void addArticle(Article article){	
		articles.add(article);
	}
	

}
