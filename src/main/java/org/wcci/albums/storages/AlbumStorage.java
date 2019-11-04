package org.wcci.albums.storages;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Comment;
import org.wcci.albums.entities.Song;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.exception.AlbumNotFound;
import org.wcci.albums.exception.SongNotFound;
import org.wcci.albums.repositories.AlbumRepository;

@Repository
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
		Optional<Album> album= albumRepo.findById(id);
		if(!album.isPresent()) {
			throw new AlbumNotFound("Album not found");
		}
		return albumRepo.findById(id).get();
	}
	
	public void addTag(Tag tag, Album album) {
		album.addTag(tag);
		albumRepo.save(album);
	}
	
	public Album addComment(Comment comment, Album album) {
		album.addComment(comment);
		return albumRepo.save(album);
		
	}
}