package watson;

import java.util.ArrayList;

import com.google.gson.JsonArray;


/**
 * This is the BookStats class.
 * It determines the percentage of each emotion present in a book's reviews.
 * @author carsonstack
 *
 */
public class BookStats {
	private Book book;
	private JsonArray JsonEmotions;
	private double percentAnger;
	private double percentDisgust;
	private double percentFear;
	private double percentJoy;
	private double percentSadness;
	private int analyzedReviews;
	private boolean analysisComplete;
	
	
	/**
	 * This is the constructor method. 
	 * It calculates the percent that each emotion is present in the reviews of a given book
	 * @param book 
	 */
	public BookStats(Book book){
		this.book = book;
		
		analyzedReviews = 0;
		analysisComplete = false;
		
		this.getFullEmotionReport();
		
	}
	
	public void getFullEmotionReport() {
		ArrayList<Review> reviews = book.getReviews();
		
		int analyzedReviews = 0;
		int angerHit = 0;
		int disgustHit = 0;
		int fearHit = 0;
		int joyHit = 0;
		int sadnessHit = 0;
		
		
		for(Review review : reviews){
			double currentAnger = review.getAnger();
			double currentDisgust = review.getDisgust();
			double currentFear = review.getFear();
			double currentJoy = review.getJoy();
			double currentSadness = review.getSadness();
			analyzedReviews++;
			if(currentAnger > .4) angerHit++;
			if(currentDisgust > .4) disgustHit++;
			if(currentFear > .4) fearHit++;
			if(currentJoy > .4) joyHit++;
			if(currentSadness > .4) sadnessHit++;
			
		}
		
		
		percentAnger = ((double)angerHit / analyzedReviews) * 100;
		percentDisgust = ((double)disgustHit / analyzedReviews) * 100;
		percentFear = ((double)fearHit / analyzedReviews) * 100;
		percentJoy = ((double)joyHit / analyzedReviews) * 100;
		percentSadness = ((double)sadnessHit / analyzedReviews) * 100;
		
		JsonArray JsonEmotions = new JsonArray();

		JsonEmotions.add(percentAnger);
		JsonEmotions.add(percentDisgust);
		JsonEmotions.add(percentFear);
		JsonEmotions.add(percentJoy);
		JsonEmotions.add(percentSadness);

		this.analysisComplete = true;
	}

	/**
	 * @return the percentAnger
	 */
	public double getPercentAnger() {
		return percentAnger;
	}

	/**
	 * @return the percentDisgust
	 */
	public double getPercentDisgust() {
		return percentDisgust;
	}

	/**
	 * @return the percentFear
	 */
	public double getPercentFear() {
		return percentFear;
	}

	/**
	 * @return the percentJoy
	 */
	public double getPercentJoy() {
		return percentJoy;
	}

	/**
	 * @return the percentSadness
	 */
	public double getPercentSadness() {
		return percentSadness;
	}

	/**
	 * @return the emotions
	 */
	public JsonArray getEmotions() {
		return JsonEmotions;
	}
	
	/**
	 * print the emotions
	 */
	public void printEmotions() {
		System.out.println(this.JsonEmotions);
	}
	
	

	
	
}
