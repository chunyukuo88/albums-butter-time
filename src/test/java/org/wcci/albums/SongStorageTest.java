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
import org.wcci.albums.entities.Song;
import org.wcci.albums.repositories.SongRepository;
import org.wcci.albums.storages.SongStorage;

public class SongStorageTest {
	
    @InjectMocks
    private SongStorage underTest;
    @Mock
    private SongRepository songRepo;
    @Mock
    private Song mockSong;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void shouldThrowNotFoundExceptionWhenSongNonexistent() {
		when(songRepo.findById(1L)).thenReturn(Optional.empty());
		try {
			underTest.findSongById(1L);
			fail("Exception not thrown.");
		} catch (Exception e) {
			assertThat(e.getMessage(), is(equalTo("No value present")));
		}
	}
}
