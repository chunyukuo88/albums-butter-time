package org.wcci.albums;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private ArtistRepository artistRepo;
	@Autowired
	private SongRepository songRepo;
	@Autowired
	private TagStorage tagStorage;

	@Test
	public void artistWillHaveAlbums() throws Exception {
		Artist testArtist = new Artist("Chuck Norris");
		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		testArtist = artistRepo.save(testArtist);
		testAlbum1 = albumRepo.save(testAlbum1);

		entityManager.flush();
		entityManager.clear();

		Artist receivedArtist = artistRepo.findById(testArtist.getId()).get();

		assertEquals(testArtist, receivedArtist);
	}

	@Test
	public void albumsHaveSongs() {
		Artist testArtist = new Artist("Chuck Norris");
		artistRepo.save(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumRepo.save(testAlbum1);

		Song testSong = new Song("Beating Bruce Lee", 1000, testAlbum1);
		songRepo.save(testSong);

		entityManager.flush();
		entityManager.clear();

		Song addedSong = songRepo.findById(testSong.getId()).get();

		assertEquals(testSong, addedSong);
	}
	
	@Ignore
	@Test
	public void anAlbumHasATag() {
		Artist testArtist = new Artist("Chuck Norris");
		artistRepo.save(testArtist);

		Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		albumRepo.save(testAlbum1);

		Tag testTag = new Tag("Anthem");

		tagStorage.addTag(testTag);


		
		testAlbum1.addTag(testTag);

		entityManager.flush();
		entityManager.clear();

		Tag addedTag = tagStorage.findTagById(testTag.getId()); 

		assertEquals(testTag, addedTag);
	}
	
}
