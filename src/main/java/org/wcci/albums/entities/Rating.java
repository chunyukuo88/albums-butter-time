package org.wcci.albums.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rating {
	@Id
	@GeneratedValue
	private Long Id;
	private int rating;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "ratings", cascade = CascadeType.ALL)
	private List<Album> albums;
	
	@JsonIgnore
	@ManyToMany (mappedBy = "ratings", cascade = CascadeType.ALL)
	private List<Song> songs;
	

	protected Rating() {
	}
	
	public Rating(int rating) {
		this.rating = rating;
	}


	public int getRating() {
		return rating;
	}


	public Long getId() {
		return Id;
	}
	
	
	
	
	
	
	

}
