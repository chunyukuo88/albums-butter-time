package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.wcci.albums.controllers.AlbumController;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;
import org.wcci.albums.entities.Comment;
import org.wcci.albums.repositories.AlbumRepository;
import org.wcci.albums.storages.AlbumStorage;

public class AlbumControllerTest {
	@InjectMocks
	private AlbumController underTest;
	
	@Mock
	private AlbumStorage albumStorage;
	
	private Album testAlbum;

	private MockMvc mockMvc;

	@Mock
	private AlbumRepository albumRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
		testAlbum = new Album("Test Album", new Artist("Test Artist"));
	}

	@Test
	public void fetchAllReturnListOfAlbums() throws Exception {
		when(albumStorage.findAllAlbums()).thenReturn(Collections.singletonList(testAlbum));
		List<Album> retrievedAlbum = underTest.fetchAll();
		assertThat(retrievedAlbum, contains(testAlbum));
	}

	@Test
	public void fetchAllIsMappedCorrectlyAndReturnsAJsonList() throws Exception {
		when(albumStorage.findAllAlbums()).thenReturn(Collections.singletonList(testAlbum));
		mockMvc.perform(get("/api/albums"))
		       .andDo(print())
		       .andExpect(status().isOk())
		       .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		       .andExpect(jsonPath("$", hasSize(1)))
			   .andExpect(jsonPath("$[0].title", is(equalTo("Test Album"))));
	}
	
	@Test
	public void fetchByIdReturnsSingleAlbum() throws Exception {
		when(albumStorage.findAlbumById(1L)).thenReturn(testAlbum);
		mockMvc.perform(get("/api/albums/1"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(jsonPath("$.title", is(equalTo("Test Album"))));
	}

	 @Test
	    public void addCommentAddsCommentsToSelectedAlbum()throws Exception {
			Album mockAlbum = mock(Album.class);
			when(mockAlbum.getId()).thenReturn(1L);
	        when(albumStorage.findAlbumById(1L)).thenReturn(mockAlbum);
	        albumStorage.addAlbum(mockAlbum);
	        
	        Comment testComment = new Comment("TESTING", "TESTY");
	        Album commentedOnAlbum = underTest.addComment(mockAlbum.getId(), testComment);
	        verify(albumStorage).addComment(testComment, mockAlbum);
	    }

}
