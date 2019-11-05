package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Album;
import org.wcci.albums.entities.Artist;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	
	public Iterable<Album> findAllByOrderByIdDesc();

	public Iterable<Album> findAllByArtist(Artist artist);

}
