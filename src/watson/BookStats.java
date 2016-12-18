package watson;

import java.util.ArrayList;
/**
 * This is the BookStats class.
 * It determines the percentage of each emotion present in a book's reviews.
 * @author carsonstack
 *
 */
public class BookStats {
	private Book book;
	private double[] emotions;
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
		emotions = new double[5];
		
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
		emotions[0] = percentAnger;
		emotions[1] = percentDisgust;
		emotions[2] = percentFear;
		emotions[3] = percentJoy;
		emotions[4] = percentSadness;
		
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
	public double[] getEmotions() {
		return emotions;
	}
	
	
	

	
	
}
