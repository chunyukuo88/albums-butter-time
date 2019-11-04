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
import org.wcci.albums.entities.Album;
import org.wcci.albums.exception.AlbumNotFound;
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.storages.AlbumStorage;

public class AlbumStorageTest {
	
    @InjectMocks
    private AlbumStorage underTest;
    @Mock
    private AlbumRepository albumRepo;
    @Mock
    private Album mockAlbum;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void shouldThrowNotFoundExceptionWhenAlbumNonexistent() {
		when(albumRepo.findById(1L)).thenReturn(Optional.empty());
		try {
			underTest.findAlbumById(1L);
			fail("Exception not thrown.");
		} catch (AlbumNotFound e) {
			assertThat(e.getMessage(), is(equalTo("Album not found")));
		}
	}
}
