package org.wcci.albums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	@ManyToOne
	private Artist artist;

	protected Album () {}
	
	public Album(String title, Artist artist) {
		this.title = title;
		this.artist = artist;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public Long getId() {
		return id;
	}
}
