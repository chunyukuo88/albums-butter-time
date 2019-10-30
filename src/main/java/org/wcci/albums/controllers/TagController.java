package org.wcci.albums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.storages.TagStorage;

@RestController
@RequestMapping("/api/tags")
public class TagController {

	@Autowired
	private TagStorage tagStorage;
	
	@GetMapping("")
	public Iterable<Tag> displayAllTags(){		
		return tagStorage.findAllTags();
	}
	
	@GetMapping("/{id}")
	public Tag fetchTagById(@PathVariable Long id) {
		return tagStorage.findTagById(id);
	}
}
