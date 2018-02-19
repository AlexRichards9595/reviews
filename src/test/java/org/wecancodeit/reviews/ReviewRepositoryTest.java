package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {
	
	private ReviewRepository underTest;

	private long firstReviewId = 23L;
	private Review firstReview = new Review(firstReviewId, "first review", "review url", "category", "content");

	private long secondReviewId = 1L;
	private Review secondReview = new Review(secondReviewId, "second review", "review url", "category", "content");

	@Test
	public void shouldFindFirstReview() {
		underTest = new ReviewRepository(firstReview);

		Review result = underTest.findOne(firstReviewId);

		assertThat(result, is(firstReview));
	}

	@Test
	public void shouldFindSecondCourse() {

		underTest = new ReviewRepository(firstReview, secondReview);

		Review result = underTest.findOne(secondReviewId);

		assertThat(result, is(secondReview));
	}

	@Test
	public void shouldFindAll() {
		underTest = new ReviewRepository(firstReview, secondReview); 

		Collection<Review> result = underTest.findAll();

		assertThat(result, containsInAnyOrder(firstReview, secondReview));
	}

}
