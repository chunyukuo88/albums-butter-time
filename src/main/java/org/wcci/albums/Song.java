package org.wcci.albums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private int duration;

	@ManyToOne
	private Artist artist;

	protected Song() {
	}

	public Song(String title, int duration, Artist artist) {
		this.duration = duration;
		this.title = title;
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public int getDuration() {
		return duration;
	}

	public Artist getArtist() {
		return artist;
	}

}
