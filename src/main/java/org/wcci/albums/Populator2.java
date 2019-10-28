package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator2 implements CommandLineRunner {
	
	@Autowired
	private SongStorage songStorage;
	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumRepository albumRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Artist artist = new Artist("Chuck Norris");
		artistRepo.save(artist);
		
		Album album = new Album("Chucky Gets Lucky", artist);
		albumRepo.save(album);
		
		Song song = new Song("My first song", 90, album);
		songStorage.addSong(song);
		
		
		
		
	}

}
