package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	public Iterable<Song> findAllByOrderByIdDesc();

	public Iterable<Song> findAllByAlbum(Album album);
	
}
