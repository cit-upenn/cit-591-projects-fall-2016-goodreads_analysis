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
	
	/**
	 * This is the constructor method. 
	 * It calculates the percent that each emotion is present in the reviews of a given book
	 * @param book 
	 */
	public BookStats(Book book){
		this.book = book;
		emotions = new double[4];
		ArrayList<Review> reviews = book.getReviews();
		int count = 0;
		int angerHit = 0;
		int disgustHit = 0;
		int fearHit = 0;
		int joyHit = 0;
		int sadnessHit = 0;
		for(Review review : reviews){
			count++;
			if(review.getAnger() > .4) angerHit++;
			if(review.getDisgust() > .4) disgustHit++;
			if(review.getFear() > .4) fearHit++;
			if(review.getJoy() > .4) joyHit++;
			if(review.getSadness() > .4) sadnessHit++;
			
		}
		percentAnger = ((double)angerHit / count) * 100;
		percentDisgust = ((double)disgustHit / count) * 100;
		percentFear = ((double)fearHit / count) * 100;
		percentJoy = ((double)joyHit / count) * 100;
		percentSadness = ((double)sadnessHit / count) * 100;
		emotions[0] = percentAnger;
		emotions[1] = percentDisgust;
		emotions[2] = percentFear;
		emotions[3] = percentJoy;
		emotions[4] = percentSadness;
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
