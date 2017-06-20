package pl.edu.agh.ki.mwo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.edu.agh.ki.mwo.model.Article;
import pl.edu.agh.ki.mwo.model.Author;
import pl.edu.agh.ki.mwo.model.Review;
import pl.edu.agh.ki.mwo.model.Reviewer;



public class ConferenceDatabase{
	
	protected static ConferenceDatabase conferenceDatabase = null;
	
	public static ConferenceDatabase getInstance()
	{
		if (conferenceDatabase == null)
		{
			conferenceDatabase = new ConferenceDatabase();
		}
		return conferenceDatabase;
	}
	
	
	protected List<Article> articles = null;
	protected ArrayList<Author> authors = null;
	protected ArrayList<Reviewer> reviewers = null;
	protected ArrayList<Review> reviews = null;
	
	protected ConferenceDatabase()
	{
		articles = new ArrayList<Article>();
		authors = new ArrayList<Author>();
		reviewers = new ArrayList<Reviewer>();
		reviews = new ArrayList<Review>();
	}
	
	
	public Iterable<Article> getArticles() {
		System.out.println("Tu jeszcze dziala");
		try{
			Session session;
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("k1");
			@SuppressWarnings("deprecation")
			Criteria crit = session.createCriteria(Article.class);
			List<Article> articles = crit.list();
			System.out.println(articles.get(0).getTitle());
			System.out.println("k2");
			session.close();
			return articles;
			
//			System.out.println("k1");
//			DatabaseConnector dbConnector = new DatabaseConnector();
//			System.out.println("k2");
//			articles=dbConnector.getArticles();
//			System.out.println("k3");
//			dbConnector.close();
		}catch (Exception e){
//		Article art1=new Article();
//		art1.setArticleId(1);
//		art1.setTitle("Jump to Space");
//		art1.setAuthorId(2);
//		art1.setScore(7);
//		art1.setStatus(1);
//		art1.setSubjectId(1);
//
//		addArticle(art1);
		
		System.out.println("Jestem w exception funkcji getArticles()");
		articles=null;
		return articles;
		}

	}
	
	public Iterable<Author> getAuthors() {
		try{
			Session session;
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("k3");
			
			@SuppressWarnings("deprecation")
			Criteria crit = session.createCriteria(Author.class);
			List<Author> authors = crit.list();
			System.out.println(authors.get(0).getName());
			System.out.println("k4");
			session.close();
			return authors;
			

		}catch (Exception e){
		
		System.out.println("Jestem w exception funkcji getAuthors()");
		authors=null;
		return authors;
		}
	}
	
	public Iterable<Reviewer> getReviewers() {
		return reviewers;
	}
	
	public Iterable<Review> getReviews() {
		return reviews;
	}
	
	public void addArticle(Article article) {
		articles.add(article);		
	}
	
	public void addAuthor(Author author) {
		authors.add(author);		
	}
	
	public void addReviewer(Reviewer reviewer) {
		reviewers.add(reviewer);
	}

	public Object getSelectedReviewers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	protected ArrayList<Student> students = null;
	
	protected ConferenceDatabase()
	{
		students = new ArrayList<Student>();
	}

	public Iterable<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);		
	}
	
	public void removeStudent(int studentId) {
		for(Student student : students)
		{
			if (student.getId() == studentId)
			{
				students.remove(student);
				return;
			}
		}
	}
	*/
}
