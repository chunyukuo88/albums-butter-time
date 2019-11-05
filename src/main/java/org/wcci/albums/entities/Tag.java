package org.wcci.albums.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy="tags", cascade = CascadeType.ALL)
	private List<Song> songList;
	@ManyToMany(mappedBy="tags", cascade = CascadeType.ALL)
	private List<Album> albumList;
	@ManyToMany(mappedBy="tags", cascade = CascadeType.ALL)
	private List<Artist> artistList;

	public Tag() {}
	
	public Tag(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumList == null) ? 0 : albumList.hashCode());
		result = prime * result + ((artistList == null) ? 0 : artistList.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((songList == null) ? 0 : songList.hashCode());
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
		Tag other = (Tag) obj;
		if (albumList == null) {
			if (other.albumList != null)
				return false;
		} else if (!albumList.equals(other.albumList))
			return false;
		if (artistList == null) {
			if (other.artistList != null)
				return false;
		} else if (!artistList.equals(other.artistList))
			return false;
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
		if (songList == null) {
			if (other.songList != null)
				return false;
		} else if (!songList.equals(other.songList))
			return false;
		return true;
	}
	
}