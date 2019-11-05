package org.wcci.albums.storages;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.exception.ArtistNotFound;
import org.wcci.albums.repositories.ArtistRepository;

@Service
public class ArtistStorage {

	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumStorage albumStorage;

	public Artist addArtist(Artist artist) {
		return artistRepo.save(artist);
	}

	public void removeArtist(Artist artist) {
		albumStorage.removeAlbumsByArtist(artist);
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

	public Artist updateArtistName(Artist artist, String name) {
		artist.updateArtistName(name);
		artistRepo.save(artist);
		return artist;
	}

	public Artist updateArtistAll(Artist artist, String name, String recordLabel, String hometown) {
		artist.updateArtistHometown(hometown);
		artist.updateArtistName(name);
		artist.updateArtistRecordLabel(recordLabel);
		artistRepo.save(artist);
		return artist;
	}
}