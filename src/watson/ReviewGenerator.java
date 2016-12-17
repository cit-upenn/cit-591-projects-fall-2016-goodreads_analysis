package watson;

import java.util.ArrayList;

public class ReviewGenerator {
	
	public ReviewGenerator(ArrayList<String> content, Book book){
		for (String each : content ) {
        	Review review = new Review(each);
        	book.addReview(review);
        }
	}

}
