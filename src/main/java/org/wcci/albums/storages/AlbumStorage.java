package org.wcci.albums.storages;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Comment;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.exception.AlbumNotFound;
import org.wcci.albums.repositories.AlbumRepository;

@Service
public class AlbumStorage {

	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private SongStorage songStorage;

	public Album addAlbum(Album album) {
		return albumRepo.save(album);
	}

	public void removeAlbum(Album album) {
		songStorage.removeSongsByAlbum(album);
		albumRepo.delete(album);
	}

	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAllByOrderByIdDesc();
	}

	public Album findAlbumById(Long id) {
		Optional<Album> album = albumRepo.findById(id);
		if (!album.isPresent()) {
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

	public void removeAlbumsByArtist(Artist artist) {
		List<Album> selectedAlbums = (List<Album>) findAllAlbumsByArtist(artist);

		for (Album album : selectedAlbums) {
			songStorage.removeSongsByAlbum(album);
			albumRepo.delete(album);
		}

	}

	private Iterable<Album> findAllAlbumsByArtist(Artist artist) {
		return albumRepo.findAllByArtist(artist);
	}

	public Album updateAlbumAll(Album album, String year, String title) {
		album.updateYear(year);
		album.updateTitle(title);
		albumRepo.save(album);
		return album;
	}
}