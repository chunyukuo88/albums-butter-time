package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private SongRepository songRepo;

	@Override
	public void run(String... args) throws Exception {

		Artist testArtist = new Artist("Nuck Chorris");
		
		Album testAlbum1 = new Album("Annihilating Entire Karate Schools", testArtist);
		
		testArtist = artistRepo.save(testArtist);
		
		testAlbum1 = albumRepo.save(testAlbum1);
	}

}
