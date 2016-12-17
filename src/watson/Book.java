package watson;

import java.util.ArrayList;

/**
 * This is the Book class.
 * It has a title and reviews of it. 
 * It can return the emotional statistics of its reviews.
 * @author carsonstack
 *
 */
public class Book {
	private String title;
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
	
	public Double getAngerPercent(){
		int count = 0;
		int hit = 0;
		for(Review review : reviews){
			count++;
			if(review.getAnger() > .5) hit++;			
		}
		return ((double)hit / count);
	}
	
	public Double getDisgustPercent(){
		int count = 0;
		int hit = 0;
		for(Review review : reviews){
			count++;
			if(review.getDisgust() > .5) hit++;			
		}
		return ((double)hit / count);
	}
	
	public Double getFearPercent(){
		int count = 0;
		int hit = 0;
		for(Review review : reviews){
			count++;
			if(review.getFear() > .5) hit++;			
		}
		return ((double)hit / count);
	}
	
	public Double getJoyPercent(){
		int count = 0;
		int hit = 0;
		for(Review review : reviews){
			count++;
			if(review.getJoy() > .5) hit++;			
		}
		return ((double)hit / count);
	}
	
	public Double getSadnessPercent(){
		int count = 0;
		int hit = 0;
		for(Review review : reviews){
			count++;
			if(review.getSadness() > .5) hit++;			
		}
		return ((double)hit / count);
	}
	
	
	
	
}
