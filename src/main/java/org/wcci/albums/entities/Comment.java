package org.wcci.albums.entities;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
public class Comment {

	private String commentator;
	
	@Lob
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentator == null) ? 0 : commentator.hashCode());
		result = prime * result + ((opinion == null) ? 0 : opinion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentator == null) {
			if (other.commentator != null)
				return false;
		} else if (!commentator.equals(other.commentator))
			return false;
		if (opinion == null) {
			if (other.opinion != null)
				return false;
		} else if (!opinion.equals(other.opinion))
			return false;
		return true;
	}
	
}

//