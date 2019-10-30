package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

}
