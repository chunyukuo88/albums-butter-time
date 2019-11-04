package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/{name}")
	public Artist addArtist(@PathVariable String name) {
		Artist artist = new Artist(name);
		return artistStorage.addArtist(artist);
	}
	
	@PostMapping("/{id}/remove")
	public void removeArtist(@PathVariable Long id) {
		Artist artist = artistStorage.findArtistById(id);
		artistStorage.removeArtist(artist);
	}
	
	@PatchMapping("/{id}/{name}")
	public Artist editArtist(@PathVariable Long id, @PathVariable String name) {
		Artist artist = artistStorage.findArtistById(id);
		return artistStorage.updateArtistName(artist, name);
	}
}
