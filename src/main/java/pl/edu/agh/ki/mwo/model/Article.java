package pl.edu.agh.ki.mwo.model;

import java.util.ArrayList;
import java.util.List;


public class Article {

	private long id;
	
	private String title;
	private long authorId;
	private boolean status;
	private double score;
	private long subjectId;
	
	private List<Review> reviews=new ArrayList<Review>();
		

	public Article(){
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}


	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public void addReview(Review review){
		reviews.add(review);
	} 
	
	
//	public void updateStatus(){
//		status=false;
//		
//		if(reviews.isEmpty()){
//			
//		}else{
//			double tmp=0;
//			for(Review review: reviews){
//				if(review.getStatus()==1){
//					tmp+=1;
//				};
//			}
//			if(tmp/reviews.size() >= 0.5){
//				status=true;
//			}
//		}
//	}
	
	public void updateScore(){
		
		score=0;
		
		if(reviews.isEmpty()){

		}else{
			for(Review review: reviews){
				score+=review.getScore();
			}
			score=score/reviews.size();
		}
	}
	
}
