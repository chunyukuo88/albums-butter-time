package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.storages.AlbumStorage;
import org.wcci.albums.storages.ArtistStorage;

@CrossOrigin
@RestController
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
	private ArtistStorage artistStorage;
	
	@Autowired
	private AlbumStorage albumStorage;

	@GetMapping("")
	public Iterable<Artist> getArtists() {
		return artistStorage.findAllArtists();
	}

	@GetMapping("/{id}")
	public Artist getSingleArtist(@PathVariable Long id) {
		return artistStorage.findArtistById(id);
	}
	
	@GetMapping("/{id}/albums")
	public List<Album> getAlbumsOfSingleArtist(@PathVariable Long id) {
		return artistStorage.findArtistById(id).getAlbums();
	}

	@PostMapping("/{name}")
	public Artist addArtist(@PathVariable String name) {
		Artist artist = new Artist(name);
		return artistStorage.addArtist(artist);
	}

	@DeleteMapping("/{id}/remove")
	public void removeArtist(@PathVariable Long id) {
		Artist artist = artistStorage.findArtistById(id);
		artistStorage.removeArtist(artist);
	}

	@PatchMapping("/{id}/{name}")
	public Artist editArtist(@PathVariable Long id, @PathVariable String name) {
		Artist artist = artistStorage.findArtistById(id);
		return artistStorage.updateArtistName(artist, name);
	}

	@PostMapping("/{id}/{name}/{RecordLabel}/{Hometown}")
	public Artist editAll(@PathVariable Long id, @PathVariable String name, @PathVariable String RecordLabel,
			@PathVariable String Hometown) {
		Artist artist = artistStorage.findArtistById(id);
		return artistStorage.updateArtistAll(artist, name, RecordLabel, Hometown);
	}
}
