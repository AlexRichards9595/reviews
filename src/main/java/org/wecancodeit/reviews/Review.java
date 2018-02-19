package org.wecancodeit.reviews;

public class Review {

	Long reviewId;
	String title;
	String imageUrl;
	String category;
	String content;

	public Long getId() {
		return reviewId;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}


	public Review(Long id, String title, String imageUrl, String category, String content) {
		this.reviewId = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
	}

}
