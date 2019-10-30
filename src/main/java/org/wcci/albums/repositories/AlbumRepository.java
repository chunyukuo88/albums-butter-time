package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

	
}
