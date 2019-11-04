package org.wcci.albums;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.exception.ArtistNotFound;
import org.wcci.albums.repositories.ArtistRepository;
import org.wcci.albums.storages.ArtistStorage;

public class ArtistStorageTest {
	
    @InjectMocks
    private ArtistStorage underTest;
    @Mock
    private ArtistRepository artistRepo;
    @Mock
    private Artist mockArtist;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void shouldThrowNotFoundExceptionWhenArtistNonexistent() {
		when(artistRepo.findById(1L)).thenReturn(Optional.empty());
		try {
			underTest.findArtistById(1L);
			fail("Exception not thrown.");
		} catch (ArtistNotFound e) {
			assertThat(e.getMessage(), is(equalTo("Artist not found")));
		}
	}
}
