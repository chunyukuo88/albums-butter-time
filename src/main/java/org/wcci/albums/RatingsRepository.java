package org.wcci.albums;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends CrudRepository<Ratings, Long> {

}
