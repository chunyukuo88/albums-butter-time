package org.wcci.albums.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String link;
	private int duration;
	@JsonIgnore
	@ManyToOne
	private Album album;
	@ManyToMany
	private List<Tag> tags;
	@ManyToMany
	private List<Rating> ratings;

	protected Song() {
	}

//	Dummy constructor for front-end testing
	public Song(String title) {
		this.title = title;
	}
	
	public Song(String title, int duration, Album album) {
		this.duration = duration;
		this.title = title;
		this.album = album;
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

	public Album getAlbum() {
		return this.album;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
	
	public void updateDuration(int duration) {
		this.duration = duration;
	}
	

	
	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", link=" + link + ", duration=" + duration + ", album=" + album
				+ ", tags=" + tags + ", ratings=" + ratings + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + duration;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Song other = (Song) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (duration != other.duration)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
