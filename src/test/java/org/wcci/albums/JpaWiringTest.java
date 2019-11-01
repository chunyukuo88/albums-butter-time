package org.wcci.albums;

import static org.junit.Assert.assertEquals;

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
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.repositories.SongRepository;
import org.wcci.albums.repositories.TagRepository;
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
	private AlbumRepository albumStorage;
	@Autowired
	private ArtistRepository artistStorage;
	@Autowired
	private SongRepository songStorage;
	@Autowired
	private TagRepository tagStorage;


	@Test
	public void artistWillHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Chuck Norris");
		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		artistStorage.save(testArtist);
		albumStorage.save(testAlbum1);

		entityManager.flush();
		entityManager.clear();

		Artist receivedArtist = artistStorage.findById(testArtist.getId()).get();

		assertEquals(testArtist, receivedArtist);
	}

	
	@Test
	public void albumsHaveSongs() {
		Artist testArtist = new Artist("Chuck Norris");
		artistStorage.save(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumStorage.save(testAlbum1);

		Song testSong = new Song("Beating Bruce Lee", 1000, testAlbum1);
		songStorage.save(testSong);

		entityManager.flush();
		entityManager.clear();

		Song addedSong = songStorage.findById(testSong.getId()).get();

		assertEquals(testSong, addedSong);
	}

	@Test
	public void anAlbumHasATag() {
		Artist testArtist = new Artist("Chuck Norris");
		artistStorage.save(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumStorage.save(testAlbum1);

		Tag testTag = new Tag("Anthem");

		tagStorage.save(testTag);

		testAlbum1.addTag(testTag);

		entityManager.flush();
		entityManager.clear();

		Tag addedTag = tagStorage.findById(testTag.getId()).get();

		assertEquals(testTag, addedTag);
	}

}
