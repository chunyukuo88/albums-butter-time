package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.storages.ArtistStorage;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Autowired
	private ArtistStorage artistStorage;	
//	@Autowired
//	private AlbumStorage albumStorage;
//	@Autowired
//	private SongStorage songStorage;
	
	
	@GetMapping("")
	public Iterable<Artist> getArtists() {
		return artistStorage.findAllArtists();
	}
	
	@GetMapping("/{id}")
	public Artist getSingleArtist(@PathVariable Long id) {
		return artistStorage.findArtistById(id);
	}

}
