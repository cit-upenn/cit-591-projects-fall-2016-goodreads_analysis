package watson;

import java.util.ArrayList;

/**
 * This is the ReviewGenerator class.
 * It creates the reviews for a book.
 * @author carsonstack
 *
 */
public class ReviewGenerator {
	
	/**
	 * This is the constructor method
	 * @param content an array of strings with review content
	 * @param book the book to create reviews for
	 */
	public ReviewGenerator(ArrayList<String> content, Book book){
		for (String each : content ) {
        	Review review = new Review(each);
        	book.addReview(review);
        }
	}

}
