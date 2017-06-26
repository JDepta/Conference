package pl.edu.agh.ki.mwo.model;

public class Review {
	private long id;
	private long articleId;
	private String reviewText;
	private boolean status;
	private double score;
	private long reviewerId;
	
	
	public Review() {
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(long idReviewer) {
		this.reviewerId = idReviewer;
	}

	public long getArticleId() {
		return articleId;
	}


	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}


	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}


	public String getReviewText() {
		return reviewText;
	}

	public void setDescription(String reviewText) {
		this.reviewText = reviewText;
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
	

}
