package watson;

import java.util.ArrayList;

/**
 * This is the Book class.
 * It has a title and reviews of it. 
 * @author carsonstack
 *
 */
public class Book {
	private String title;
	private String author;
	private ArrayList<Review> reviews;
	
	/**
	 * This is the constructor method.
	 * @param title
	 */
	public Book(String title) {
		this.title = title;
		reviews = new ArrayList<Review>();
		
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
	
	/**
	 * setter for the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * setter for the author
	 */
	public void setAuthor(String name) {
		this.author = name;
	}
	
	/**
	 * getter for the author
	 * 
	 * @return author name
	 */
	public String getAuthor() {
		return this.author;
	}
	
}
