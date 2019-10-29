package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistStorage {

	@Autowired
	private ArtistRepository artistRepo;

	public void addArtist(Artist artist) {
		artistRepo.save(artist);
	}
		
	public void removeArtist(Artist artist) {
		artistRepo.delete(artist);
	}

	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}
	
	public Artist findArtistById(Long id) {
		Artist artist = artistRepo.findById(id).get();
//		.findById() returns an optional. The ensuing .get() gives you the object of that optional.
		return artist;
	}

}
