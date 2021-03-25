package model;

public class Stand {
	
	private String type = "Stand";
	
	private String id;
	
	private int score;
	
	public Stand() {}

	public Stand(int score) {
		super();
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
