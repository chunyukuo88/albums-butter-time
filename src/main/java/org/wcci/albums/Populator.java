package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Rating;
import org.wcci.albums.entities.Song;
import org.wcci.albums.storages.AlbumStorage;
import org.wcci.albums.storages.ArtistStorage;
import org.wcci.albums.storages.RatingStorage;
import org.wcci.albums.storages.SongStorage;

@Component
public class Populator implements CommandLineRunner{

	@Autowired
	private ArtistStorage artistStorage;
	@Autowired
	private AlbumStorage albumStorage;
	@Autowired
	private SongStorage songStorage;
	@Autowired
	private RatingStorage ratingsStorage;

	@Override
	public void run(String... args) throws Exception {
		
		Artist artist = new Artist("Chuck Norris");
		artistStorage.addArtist(artist);
		
		Album album = new Album("Chucky Gets Lucky", artist);
		albumStorage.addAlbum(album);
		
		Song song = new Song("My first song", 90, album);
		songStorage.addSong(song);
		
		Rating rating = new Rating(5);
		ratingsStorage.addRatings(rating);
		
		rating = new Rating(4);
		ratingsStorage.addRatings(rating);
		
		rating = new Rating(3);
		ratingsStorage.addRatings(rating);
		
		rating = new Rating(2);
		ratingsStorage.addRatings(rating);
		
		rating = new Rating(1);
		ratingsStorage.addRatings(rating);
		

		artist = new Artist("Nuck Chorris");		
		album = new Album("Annihilating Entire Karate Schools", artist);		
		artistStorage.addArtist(artist);		
		albumStorage.addAlbum(album);
		
		artist = new Artist("George Straaaaateeee");
		album = new Album("Country Twang", artist);
		song = new Song("Booyah", 260, album);
//		Comment comment = new Comment("Internet Troll", "This is my favorite.");
//		albumStorage.addComment(album, comment);
		
		artist = new Artist("Maurice Ravel");
		album = new Album("Orchestral Works", artist);
		song = new Song("First Piano Concerto", 2500, album);
	
	}

}
