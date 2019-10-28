package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SongStorage {

	@Autowired
	private SongRepository songRepo;
	
	public void addSong(Song song) {
		songRepo.save(song);		
	}

	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}
		
	
}
