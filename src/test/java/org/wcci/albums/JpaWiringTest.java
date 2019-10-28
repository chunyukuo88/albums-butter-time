package org.wcci.albums;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	private Album albumRepo;
	private ArtistRepository artistRepo;
	
	@Test
	public void artistWillHaveAlbums() throws Exception {
		 Artist testArtist = new Artist("Chuck Norris");
		 Album testAlbum1 = new Album("Roundhouse Kicks II", testArtist);
		 testArtist = artistRepo.save(testArtist);
		 testAlbum1 = albumRepo.save(testAlbum1);
	}
}
