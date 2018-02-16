package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ReviewRepositoryTest {
	
	private ReviewRepository underTest;

	private long firstReviewId = 23L;
	private Review firstReview = new Review(firstReviewId, "first review", "review url", "category", "content");

	private long secondReviewId = 23L;
	private Review secondReview = new Review(secondReviewId, "second review", "review url", "category", "content");

	@Test
	public void shouldFindFirstReview() {
		underTest = new ReviewRepository(firstReview);

		Review result = underTest.findOne(firstReviewId);

		assertThat(result, is(firstReview));
	}

//	@Test
//	public void shouldFindSecondCourse() {
//
//		underTest = new CourseRepository(firstCourse, secondCourse);
//
//		Course result = underTest.findOne(secondCourseId);
//
//		assertThat(result, is(secondCourse));
//	}
//
//	@Test
//	public void shouldFindAll() {
//		underTest = new CourseRepository(firstCourse, secondCourse); 
//
//		Collection<Course> result = underTest.findAll();
//
//		assertThat(result, containsInAnyOrder(firstCourse, secondCourse));
//	}

}
