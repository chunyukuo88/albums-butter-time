package org.wcci.albums.storages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.albums.entities.Rating;
import org.wcci.albums.repositories.RatingRepository;

@Service
public class RatingStorage {
	
	@Autowired
	private RatingRepository ratingsRepo;
	
	public void addRatings(Rating rating) {
		ratingsRepo.save(rating);
	}


}
