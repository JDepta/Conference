package pl.edu.agh.ki.mwo.model;

public class Review {
	private long id;
	private long idReviewer;
	private String description;
	private int status;
	private int score;
	
	
	public Review(long id, long idReviewer, String description, int status, int score) {
		this.id = id;
		this.idReviewer = idReviewer;
		this.description = description;
		this.status = status;
		this.score = score;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
