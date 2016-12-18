package watson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;

public class GRReviewFactory {
	
	
	
	
	public static BookStats getReviews(String bookName, int reviewCount) throws IOException {
		
		//create book
		Book book = new Book(bookName);
		
		GoodReadsAPI gr = new GoodReadsAPI(book, reviewCount);

		
		//create BookStat object and return the array of emotion scores
		BookStats testStats = new BookStats(book);
		double[] statsArray = testStats.getEmotions();
		
		testStats.generateFullEmotionReport();
		
		return testStats;
	}
}
