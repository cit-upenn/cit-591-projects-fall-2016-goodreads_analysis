package watson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;

public class GRReviewFactory {
	
	
	
	
	public static JsonArray getReviews(String bookName, int reviewCount) throws IOException {
		
		//create book
		Book book = new Book(bookName);
		
		GoodReads gr = new GoodReads(book, reviewCount);

		
		//create BookStat object and return the array of emotion scores
		BookStats testStats = new BookStats(book);
		double[] statsArray = testStats.getEmotions();
		
		JsonArray jsArray = new JsonArray();
		jsArray.add(statsArray[0]);
		jsArray.add(statsArray[1]);
		jsArray.add(statsArray[2]);
		jsArray.add(statsArray[3]);
		jsArray.add(statsArray[4]);
		
		return jsArray;
	}
}
