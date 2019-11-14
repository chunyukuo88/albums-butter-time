package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Comment;
import org.wcci.albums.storages.AlbumStorage;
import org.wcci.albums.storages.ArtistStorage;

@CrossOrigin
@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Autowired
	AlbumStorage albumStorage;
	
	@Autowired
	ArtistStorage artistStorage;

	@GetMapping("")
	public List<Album> fetchAll() {
		return (List<Album>) albumStorage.findAllAlbums();
	}

	@GetMapping("/{id}")
	public Album fetchById(@PathVariable Long id) {
		return albumStorage.findAlbumById(id);
	}
	
	@GetMapping("/{id}/get-artist")
	public Artist getArtistOfTheAlbum(@PathVariable Long id) {
		return albumStorage.findAlbumById(id).getArtist();
	}

	@PatchMapping("/{id}/add-comment")
	public Album addComment(@PathVariable long id, @RequestBody Comment comment) {
		Album album = albumStorage.findAlbumById(id);
		return albumStorage.addComment(comment, album);
	}

	@PostMapping("/add-album/{artistId}/{title}")
	public Album addAlbum(@PathVariable Long artistId, @PathVariable String title) {
		Artist artist = artistStorage.findArtistById(artistId);
		Album album = new Album(title, artist);
		return albumStorage.addAlbum(album);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removeAlbum(@PathVariable Long id) {
		Album album = albumStorage.findAlbumById(id);
		albumStorage.removeAlbum(album);
	}
	
	@PostMapping("/{id}/{year}/{title}")
	public Album editAll(@PathVariable Long id, @PathVariable String year, @PathVariable String title) {
		Album album = albumStorage.findAlbumById(id);
		return albumStorage.updateAlbumAll(album, year, title);
	}

}
