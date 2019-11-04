package org.wcci.albums.storages;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.exception.ArtistNotFound;
import org.wcci.albums.repositories.ArtistRepository;

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
		Optional<Artist> artist = artistRepo.findById(id);
		if (!artist.isPresent()) {
			throw new ArtistNotFound("Artist not found");
		}

		return artist.get();
	}
}
