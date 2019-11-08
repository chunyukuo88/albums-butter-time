package org.wcci.albums.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Song;
import org.wcci.albums.exception.SongNotFound;
import org.wcci.albums.repositories.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongStorage {

	@Autowired
	private SongRepository songRepo;
	
	public Song addSong(Song song) {
		return songRepo.save(song);		
	}
	
	public void removeSong(Song song) {
		songRepo.delete(song);
	}

	public Iterable<Song> findAllSongs() {
		return songRepo.findAllByOrderByIdDesc();
	}

	public Song findSongById(Long id) {
		Optional<Song> song = songRepo.findById(id); 
		if(!song.isPresent()) {
			throw new SongNotFound("Song not found");
		}
		
		return song.get();
	}

	public void removeSongsByAlbum(Album album) {
		List<Song> selectedSongs = (List<Song>) findAllSongsByAlbum(album);
		
		for (Song song : selectedSongs) {
			songRepo.delete(song);
		}
		
	}

	private Iterable<Song> findAllSongsByAlbum(Album album) {
		return songRepo.findAllByAlbum(album);
	}

	public Song updateSongAll(Song song, int duration, String title) {
		song.updateDuration(duration);
		song.updateTitle(title);
		songRepo.save(song);
		return song;
	}


}
