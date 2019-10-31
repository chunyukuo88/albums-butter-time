package org.wcci.albums;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Song;
import org.wcci.albums.entities.Tag;
import org.wcci.albums.storages.AlbumStorage;
import org.wcci.albums.storages.ArtistStorage;
import org.wcci.albums.storages.SongStorage;
import org.wcci.albums.storages.TagStorage;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private AlbumStorage albumStorage;
	@Autowired
	private ArtistStorage artistStorage;
	@Autowired
	private SongStorage songStorage;
	@Autowired
	private TagStorage tagStorage;

	@Ignore 
	@Test
	public void artistWillHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Chuck Norris");
		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		artistStorage.addArtist(testArtist);
		albumStorage.addAlbum(testAlbum1);

		entityManager.flush();
		entityManager.clear();

		Artist receivedArtist = artistStorage.findArtistById(testArtist.getId());

		assertEquals(testArtist, receivedArtist);
	}

	@Ignore
	@Test
	public void albumsHaveSongs() {
		Artist testArtist = new Artist("Chuck Norris");
		artistStorage.addArtist(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumStorage.addAlbum(testAlbum1);

		Song testSong = new Song("Beating Bruce Lee", 1000, testAlbum1);
		songStorage.addSong(testSong);

		entityManager.flush();
		entityManager.clear();

		Song addedSong = songStorage.findSongById(testSong.getId());

		assertEquals(testSong, addedSong);
	}

	@Ignore 
	@Test
	public void anAlbumHasATag() {
		Artist testArtist = new Artist("Chuck Norris");
		artistStorage.addArtist(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumStorage.addAlbum(testAlbum1);

		Tag testTag = new Tag("Anthem");

		tagStorage.addTag(testTag);

		testAlbum1.addTag(testTag);

		entityManager.flush();
		entityManager.clear();

		Tag addedTag = tagStorage.findTagById(testTag.getId());

		assertEquals(testTag, addedTag);
	}

}
