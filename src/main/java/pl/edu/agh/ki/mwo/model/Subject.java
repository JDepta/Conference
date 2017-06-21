package pl.edu.agh.ki.mwo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject {

	private long subjectId;
	private String subject;
	
	private Set<Article> articles;
		

	public Subject(){
		articles = new HashSet<Article>();
	}


	public long getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Set<Article> getArticles() {
		return articles;
	}


	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article newArticle) {
		articles.add(newArticle);
	}
	
	
}
