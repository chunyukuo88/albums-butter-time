package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs")
public class SongController {

	@Autowired
	private SongStorage songStorage;
	
	@GetMapping("")
	public Iterable<Song> displayAllSongs(){		
		return songStorage.findAllSongs();
	}
	
		
}
