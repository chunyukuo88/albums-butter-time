package org.wcci.albums;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	@Resource
	ArtistRepository artists;
	
	@Resource
	AlbumRepository albums;
	
	@GetMapping("")
	public Iterable<Artist> getArtists() {
		return artists.findAll();
	}
	
	@GetMapping("/{id}")
	public Artist getSingleArtist(@PathVariable Long id) {
		return artists.findById(id).get();
	}
//	.findById() returns an optional. The ensuing .get() gives you the object of that optional.
}
