package org.wcci.albums;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ratings {
	@Id
	@GeneratedValue
	private Long Id;
	private int rating;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "ratings")
	private List<Album> albums;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "ratings")
	private List<Song> songs;
	

	protected Ratings() {
	}
	
	public Ratings(int rating) {
		this.rating = rating;
	}


	public int getRating() {
		return rating;
	}


	public Long getId() {
		return Id;
	}
	
	
	
	
	
	
	

}
