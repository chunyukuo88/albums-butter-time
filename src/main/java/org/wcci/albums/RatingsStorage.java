package org.wcci.albums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RatingsStorage {
	
	@Autowired
	private RatingsRepository ratingsRepo;
	
	public void addRatings(Ratings rating) {
		ratingsRepo.save(rating);
	}


}
