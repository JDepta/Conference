package pl.edu.agh.ki.mwo.model;

import java.util.ArrayList;
import java.util.List;

public class Article {
	private long articleId;
	private String title;
	private long authorId;
	private int status;
	private int score;
	private long subjectId;
	
	private List<Review> reviews=new ArrayList<Review>();
		
//	public Article(long authorId, String title) {
//		this.authorId = authorId;
//		this.title = title;
//	}
	

	public Article(){
	}
	

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
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
	
	
	public void updateStatus(){
		status=0;
		
		if(reviews.isEmpty()){
			
		}else{
			double tmp=0;
			for(Review review: reviews){
				if(review.getStatus()==1){
					tmp+=1;
				};
			}
			if(tmp/reviews.size() >= 0.5){
				status=1;
			}
		}
	}
	
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
