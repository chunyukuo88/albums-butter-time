package org.wcci.albums.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Song;
import org.wcci.albums.exception.SongNotFound;
import org.wcci.albums.repositories.SongRepository;
import java.util.Optional;

@Repository
public class SongStorage {

	@Autowired
	private SongRepository songRepo;
	
	public void addSong(Song song) {
		songRepo.save(song);		
	}
	
	public void removeSong(Song song) {
		songRepo.delete(song);
	}

	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}

	public Song findSongById(Long id) {
		Optional<Song> song = songRepo.findById(id); 
		if(!song.isPresent()) {
			throw new SongNotFound("Song not found");
		}
		
		return song.get();
	}
	
	
		

}
