package watson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;

/**
 * This is the GRReviewFactory class.
 * It can create the objects necessary to generate a book's emotional statistics.
 * @author carsonstack
 *
 */
public class GRReviewFactory {	
	
	/**
	 * This method generates a BookStat object based on a book and number of reviews.
	 * @param bookName The name of the book to be examined
	 * @param reviewCount The number of reviews to consider
	 * @return the BookStats object created.
	 * @throws IOException
	 */
	public static BookStats getReviews(String bookName, int reviewCount) throws IOException {
		
		//create book
		Book book = new Book(bookName);
		
		GoodReadsAPI gr = new GoodReadsAPI(book, reviewCount);

		
		//create BookStat object and return the array of emotion scores
		BookStats testStats = new BookStats(book);
		

		return testStats;
	}
}
