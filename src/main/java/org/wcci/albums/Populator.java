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
		artist = artistStorage.addArtist(artist);
		Album album = new Album("Chucky Gets Lucky", artist);
		albumStorage.addAlbum(album);
		Song song = new Song("My first song", 90, album);
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
		

		Artist NuckChorris = new Artist("Nuck Chorris");		
		artist = artistStorage.addArtist(NuckChorris);		
		Album karateSchools = new Album("Annihilating Entire Karate Schools", artist);		
		album = albumStorage.addAlbum(karateSchools);
		Song booyah = new Song("Booyah", 260, album);
		song = songStorage.addSong(booyah);
		Song secondSong = new Song("The Second Song", 222, album);
		song = songStorage.addSong(secondSong);
		
		album = new Album("Learning Italian with Nuck Chorris", artist);
		albumStorage.addAlbum(album);
		
		artist = new Artist("George Straaaaateeee");
		artistStorage.addArtist(artist);		
		album = new Album("Country Twang", artist);
		albumStorage.addAlbum(album);

	
	}

}
