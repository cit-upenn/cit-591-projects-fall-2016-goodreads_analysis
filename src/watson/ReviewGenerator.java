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
	 * This is the reviewLoader method
	 * It takes in an array list of review contents and a book and creates each review for the book.
	 * @param content an array of strings with review content
	 * @param book the book to create reviews for
	 */
	public static void reviewLoader(ArrayList<String> content, Book book){
		for (String each : content ) {
        	Review review = new Review(each);
        	book.addReview(review);
        }
	}

}
