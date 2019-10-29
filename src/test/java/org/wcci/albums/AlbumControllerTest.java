package org.wcci.albums;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
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

public class AlbumControllerTest {
	@InjectMocks
	private AlbumController underTest;
	
	@Mock
	private AlbumStorage albumStorage;

	private Album testAlbum;

	private MockMvc mockMvc;
	// Still useful even though this isn't an MVC app because it will send requests
	// to the server and get responses back.

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
		// Fluid API: Able to chain methods together
	}
	
//	@Ignore //Add this ignore to skip a test without having to comment out code.
	@Test
	public void fetchByIdReturnsSingleAlbum() throws Exception {
//		when(albumStorage.findAlbumById(1L)).thenReturn(Optional.of(testAlbum));
		when(albumStorage.findAlbumById(1L)).thenReturn(testAlbum);
		mockMvc.perform(get("/api/albums/1"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(jsonPath("$.title", is(equalTo("Test Album"))));
		// $ represents the json body
	}

}
