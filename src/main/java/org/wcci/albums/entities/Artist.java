package org.wcci.albums.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private LocalDate dateOfBirth;
	private String recordLabel;
	private String hometown;
	@OneToMany(mappedBy="artist", cascade = CascadeType.ALL)
	private List<Album> albums;
	
	@ManyToMany
	private List<Tag> tags;
	
	protected Artist () {}
	
	public Artist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public String getHometown() {
		return hometown;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	
	public void updateArtistName(String name) {
		this.name = name;
	}
	
	public void updateArtistDob(LocalDate dob) {
		this.dateOfBirth= dob;
	}
	
	public void updateArtistHometown(String hometown) {
		this.hometown= hometown; 
	}
	
	public void updateArtistRecordLabel(String recordLabel) {
		this.recordLabel= recordLabel; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Artist other = (Artist) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
