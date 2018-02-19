package org.wecancodeit.reviews;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class ReviewControllerTest {
	


		private static final long REVIEW_ID = 42L;

		@InjectMocks
		private ReviewController underTest;

		@Mock
		private ReviewRepository repository;

		@Mock
		private Model model;

		@Mock
		private Review review;

		@Mock
		private Review anotherReview;

		@Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void shouldAddASingleReviewToModel() {
			// arrange
			when(repository.findOne(REVIEW_ID)).thenReturn(review);

			// act
			underTest.showReview(REVIEW_ID, model);

			// assert [note that "selectedReview" is arbitrary -- it's whatever you named
			// your model attribute]
			verify(model).addAttribute("reviews", review);
		}

		/**
		 * This test does state (rather than behavior) verification since it's
		 * appropriate. Note that since we're only testing for what it's returning, we
		 * don't need to set up any mock behavior.
		 */
		@Test
		public void shouldReturnNameOfSingleReviewTemplate() {
			String result = underTest.showReview(REVIEW_ID, model);

			// "singleReviewTemplate" is arbitrary -- my template is singleReviewTemplate.html
			assertThat(result, is("review"));
		}
		
		@Test
		public void shouldAddAllReviewsToModel() {
			Collection<Review> allReviews = Arrays.asList(review, anotherReview);
			when(repository.findAll()).thenReturn(allReviews);
			
			underTest.showAllReviews(model);
			
			verify(model).addAttribute("allReviews", allReviews);
		}
		
		@Test
		public void shouldReturnNameOfAllReviewsTemplate() {
			// you can do this one
		}
	


}
