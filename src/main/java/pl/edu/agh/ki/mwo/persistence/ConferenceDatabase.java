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
import pl.edu.agh.ki.mwo.model.Subject;



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
	protected List<Subject> subjects = null;
	
	protected ConferenceDatabase()
	{
		articles = new ArrayList<Article>();
		authors = new ArrayList<Author>();
		reviewers = new ArrayList<Reviewer>();
		reviews = new ArrayList<Review>();
		subjects = new ArrayList<Subject>();
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
			
		}catch (Exception e){

		System.out.println("Jestem w exception funkcji getArticles()");
		articles=null;
		return articles;
		}

	}
	
	public Iterable<Article> getArticlesAuthorView(long authorId) {
		try{
			Session session;
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("k1");
			
			String hql = "FROM Article A WHERE A.authorId="+authorId;
			
			System.out.println("k2");
			@SuppressWarnings("deprecation")
			Query query = session.createQuery(hql);
			
			System.out.println("k3");
			@SuppressWarnings("deprecation")
			List articles = query.list();
			
			System.out.println("k4");
			session.close();
			return articles;
			
		}catch (Exception e){

		System.out.println("Jestem w exception funkcji getArticlesAuthorView()");
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
	
	public Iterable<Review> getReviews(long articleId) {
		try{
			System.out.println("Jestem w try funkcji getReviews");
			Session session;
			session = HibernateUtil.getSessionFactory().openSession();
			
			//System.out.println("k1");
			
			String hql = "FROM Review R WHERE R.articleId="+articleId;
			
			System.out.println("k2");
			@SuppressWarnings("deprecation")
			Query query = session.createQuery(hql);
			
			System.out.println("k3");
			@SuppressWarnings("deprecation")
			List reviews = query.list();
			
			System.out.println("k4");
			session.close();
			
			return reviews;
		}catch (Exception e){
			
			System.out.println("Jestem w exception funkcji getReviews()");
			reviews=null;
			return reviews;
			}
	}
	
	
	public void addArticle(String title, String subject) {
		Transaction transaction = null;
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();

		try{
			System.out.println("jestem w try funkcji AddArticle()");
			//Czy parametry zostaly przekazane
			System.out.println(title);
			System.out.println(subject);

			System.out.println("k7");
			
			//Proba dodania artykulu do bazy
	    	long authorId=1; //tu powinno sczytac id autora, który się zalogowal (domyslnie zakladam, ze 1)
	    	Article newArticle=new Article();
	    	newArticle.setTitle(title);
	    	newArticle.setAuthorId(authorId);
	    	newArticle.setStatus(false);
	    	newArticle.setScore(0);
	    	newArticle.setSubjectId(2);
	    	
	    	transaction = session.beginTransaction();


	    	System.out.println("k8");
	    	
	    	System.out.println(session.isConnected());
	    	System.out.println(session.isOpen());
			session.save(newArticle);
			System.out.println("k9");
			transaction.commit();
			
		}catch (Exception e){
			if (transaction!=null) transaction.rollback();

		System.out.println("Jestem w exception funkcji addArticle()");
		System.out.println("Nie udalo sie dodac artykulu");
		e.printStackTrace();

		}
		session.close();
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


	public Object getArticles(int authorId) {
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
