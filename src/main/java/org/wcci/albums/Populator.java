package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner{

	@Autowired
	private ArtistStorage artistStorage;
	@Autowired
	private AlbumStorage albumStorage;
	@Autowired
	private SongStorage songStorage;

	@Override
	public void run(String... args) throws Exception {
		
		Artist artist = new Artist("Chuck Norris");
		artistStorage.addArtist(artist);
		
		Album album = new Album("Chucky Gets Lucky", artist);
		albumStorage.addAlbum(album);
		
		Song song = new Song("My first song", 90, album);
		songStorage.addSong(song);

		artist = new Artist("Nuck Chorris");		
		album = new Album("Annihilating Entire Karate Schools", artist);		
		artistStorage.addArtist(artist);		
		albumStorage.addAlbum(album);
		
		artist = new Artist("George Straaaaateeee");
		album = new Album("Country Twang", artist);
		song = new Song("Booyah", 260, album);
		
		artist = new Artist("Maurice Ravl");
		album = new Album("Orchestral Works", artist);
		song = new Song("First Piano Concerto", 2500, album);
		
		
		
	}

}
