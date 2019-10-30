package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Song;
import org.wcci.albums.storages.SongStorage;

@RestController
@RequestMapping("/api/songs")
public class SongController {

	@Autowired
	private SongStorage songStorage;
	
	@GetMapping("")
	public Iterable<Song> displayAllSongs(){		
		return songStorage.findAllSongs();
	}
	
	@GetMapping("/{id}")
	public Song getSingleSong(@PathVariable Long id) {
		return songStorage.findSongById(id);
	}
	
		
}
