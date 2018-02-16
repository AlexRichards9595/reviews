package org.wecancodeit.reviews;

import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {
	
	Map<Long, Review> reviews = new HashMap<>();

	public ReviewRepository(Review firstReview) {
		reviews.put(firstReview.getId(), firstReview);
	}

	public Review findOne(long firstReviewId) {
		return reviews.get(firstReviewId);
	}

}
