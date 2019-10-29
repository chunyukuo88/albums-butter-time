package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagStorage {

	@Autowired
	private TagRepository tagRepo;
	
	public void addTag(Tag tag) {
		tagRepo.save(tag);
	}
		
	public void removeTag(Tag tag) {
		tagRepo.delete(tag);
	}

	public Iterable<Tag> findAllTags() {
		return tagRepo.findAll();
	}
	
	public Tag findTagById(Long id) {
		return tagRepo.findById(id).get();
	}

}