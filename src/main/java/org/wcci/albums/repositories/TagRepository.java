package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
