package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	Map<Long, Review> reviews = new HashMap<>();
	
	public ReviewRepository () {
		Review fellowship = new Review(1L, "The Fellowship of the Ring", "./images/fellowship.jpg", "movies", "Its a good movie");
		Review twoTowers = new Review(2L, "The Two Towers", "./images/twoTowers.jpg", "movies", "Its a great movie");
		Review returnOfTheKing = new Review(3L, "The Return of the King", "./images/returnOfTheKing.jpg", "movies", "It's the best movie");
		
		reviews.put(fellowship.getId(), fellowship);
		reviews.put(twoTowers.getId(), twoTowers);
		reviews.put(returnOfTheKing.getId(), returnOfTheKing);
		
	}

	public ReviewRepository(Review... reviews) {
		populateReviewsMap(reviews);
	}

	private void populateReviewsMap(Review... reviews) {
		for (Review review : reviews) {
			this.reviews.put(review.getId(), review);
		}
	}

	public Review findOne(Long reviewId) {
		return reviews.get(reviewId);
	}

	public Collection<Review> findAll() {
		return reviews.values();
	}
	

}
