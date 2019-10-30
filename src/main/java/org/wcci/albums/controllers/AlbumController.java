package org.wcci.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Album;
import org.wcci.albums.storages.AlbumStorage;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

	@Autowired
	AlbumStorage albumStorage;
	
	@GetMapping("")
	public List<Album> fetchAll() {
		return (List<Album>) albumStorage.findAllAlbums();
	}
	
	@GetMapping("/{id}") 
	public Album fetchById(@PathVariable Long id) {
		return albumStorage.findAlbumById(id);
	}

}
