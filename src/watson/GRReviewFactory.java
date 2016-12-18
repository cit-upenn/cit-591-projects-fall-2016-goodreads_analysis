package watson;

import java.io.IOException;
import java.util.ArrayList;

public class GRReviewFactory {
	
	
	
	
	public static double[] getReviews(String bookName, int reviewCount) throws IOException {
		
		//create book
		Book book = new Book(bookName);
		
		GoodReads gr = new GoodReads(book, reviewCount);

		
		//
		BookStats testStats = new BookStats(book);
		
		return testStats.getEmotions();
		
	}
}
