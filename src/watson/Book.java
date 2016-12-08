package watson;

import java.util.ArrayList;

public class Book {
	private String title;
	private ArrayList<Review> reviews;
	
	public Book(String title) {
		this.title = title;
	}
	
	/**
	 * add a review to the arraylist of reviews for the book
	 * @param review
	 */
	public void addReview(Review review) {
		reviews.add(review);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the reviews
	 */
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	
}
