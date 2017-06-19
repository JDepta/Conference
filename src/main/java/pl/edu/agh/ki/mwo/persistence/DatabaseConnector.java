package pl.edu.agh.ki.mwo.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pl.edu.agh.ki.mwo.model.Article;

public class DatabaseConnector {

	Session session;

	public DatabaseConnector() {
		System.out.println("Tu jeszcze dziala 2");
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Tu jeszcze dziala 3");
	}


	public void close() {
		session.close();
		HibernateUtil.shutdown();
	}

	public List<Article> getArticles() {
		System.out.println("Tu jeszcze dziala 4");
		@SuppressWarnings("deprecation")
		Criteria crit = session.createCriteria(Article.class);
		List<Article> articles = crit.list();
		System.out.println(articles.get(0).getTitle());
		System.out.println("Tu jeszcze dziala 5");
		return articles;
	}


}
