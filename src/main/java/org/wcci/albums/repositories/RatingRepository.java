package org.wcci.albums.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wcci.albums.entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

}
