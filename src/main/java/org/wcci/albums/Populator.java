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
		
		Artist artist = new Artist("Chris Bacon");
		artist = artistStorage.addArtist(artist);
		Album album = new Album("Pigs in a blanket", artist);
		albumStorage.addAlbum(album);
		Song song = new Song("Sunday morning sizzle", 90, album);
		songStorage.addSong(song);
		Song luckyCharms = new Song("Lucky Charms", 888, album);
		songStorage.addSong(luckyCharms);
		
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
		

		Artist GerogeButter = new Artist("Geroge Butter");		
		artist = artistStorage.addArtist(GerogeButter);		
		Album TableSpoons = new Album("TableSpoons", artist);		
		album = albumStorage.addAlbum(TableSpoons);
		Song SticksOnSticks = new Song("Sticks on Sticks", 260, album);
		song = songStorage.addSong(SticksOnSticks);
		Song ChurnBabyChurn = new Song("Churn Baby Churn", 222, album);
		song = songStorage.addSong(ChurnBabyChurn);
		
		album = new Album("Learning the spread", artist);
		albumStorage.addAlbum(album);
		
		artist = new Artist("Carter Cobb");
		artistStorage.addArtist(artist);		
		album = new Album("Stocks a mile high", artist);
		albumStorage.addAlbum(album);

	
	}

}
