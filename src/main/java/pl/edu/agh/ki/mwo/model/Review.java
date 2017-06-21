package pl.edu.agh.ki.mwo.model;

public class Review {
	private long id;
	private long idReviewer;
	private String reviewText;
	private int status;
	private int score;
	
	
	public Review() {
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdReviewer() {
		return idReviewer;
	}

	public void setIdReviewer(long idReviewer) {
		this.idReviewer = idReviewer;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setDescription(String reviewText) {
		this.reviewText = reviewText;
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
	

}
