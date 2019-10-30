package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

	
}
