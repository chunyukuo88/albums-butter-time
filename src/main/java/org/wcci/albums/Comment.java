package org.wcci.albums;

import javax.persistence.Embeddable;

@Embeddable
public class Comment {

	private String commentator;
	private String opinion;
	
	public Comment() {}
	
	public Comment(String commentator, String opinion) {
		this.commentator = commentator;
		this.opinion = opinion;
	}

	public String getCommentator() {
		return commentator;
	}

	public String getOpinion() {
		return opinion;
	}
	
}

//