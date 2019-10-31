package org.wcci.albums.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Comment;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.repositories.AlbumRepository;

@Service
public class AlbumStorage {

	@Autowired
	private AlbumRepository albumRepo;

	public void addAlbum(Album album) {
		albumRepo.save(album);
	}
		
//	public void removeAlbum(Album album) {
//		albumRepo.delete(album);
//	}

	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}
	
	public Album findAlbumById(Long id) {
		return albumRepo.findById(id).get();
	}

	public void addTag(Tag tag, Album album) {
		album.addTag(tag);
		albumRepo.save(album);
	}
	
	public void addComment(Comment comment, Album album) {
		album.addComment(comment);
		albumRepo.save(album);
	}
}