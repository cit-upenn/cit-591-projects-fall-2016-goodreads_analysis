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
	

	/**
	 * This method calculates the percent of emotions present in reviews for a given book.
	 */
    public void getFullEmotionReport() {
		ArrayList<Review> reviews = book.getReviews();
		
		int analyzedReviews = 0;
		int angerHit = 0;
		int disgustHit = 0;
		int fearHit = 0;
		int joyHit = 0;
		int sadnessHit = 0;
		
		for(Review review : reviews){
			analyzedReviews++;
			if(review.getAnger() > .4) angerHit++;
			if(review.getDisgust() > .4) disgustHit++;
			if(review.getFear() > .4) fearHit++;
			if(review.getJoy() > .4) joyHit++;
			if(review.getSadness() > .4) sadnessHit++;
			
		}
		
		
		setPercentAnger(( (double)angerHit / analyzedReviews) * 100);
		setPercentDisgust(((double)disgustHit / analyzedReviews) * 100);
		setPercentFear(((double)fearHit / analyzedReviews) * 100);
		setPercentJoy(((double)joyHit / analyzedReviews) * 100);
		setPercentSadness(((double)sadnessHit / analyzedReviews) * 100);
//		percentDisgust = ((double)disgustHit / analyzedReviews) * 100;
//		percentFear = ((double)fearHit / analyzedReviews) * 100;
//		percentJoy = ((double)joyHit / analyzedReviews) * 100;
//		percentSadness = ((double)sadnessHit / analyzedReviews) * 100;
		
		
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
	
	/**
	 * sets the percentAnger
	 * @param percentAnger
	 */
	public void setPercentAnger(double percentAnger) {
	        this.percentAnger = percentAnger;
	    }

	/**
	 * sets the percentDisgust
	 * @param percentDisgust
	 */
	public void setPercentDisgust(double percentDisgust) {
	        this.percentDisgust = percentDisgust;
	    }

	/**
	 * sets the percentFear
	 * @param percentFear
	 */
	public void setPercentFear(double percentFear) {
	        this.percentFear = percentFear;
	    }

	/**
	 * sets the percentJoy
	 * @param percentJoy
	 */
	public void setPercentJoy(double percentJoy) {
	        this.percentJoy = percentJoy;
	    }


	/**
	 * sets the percentSadness
	 * @param percentSadness
	 */
	public void setPercentSadness(double percentSadness) {
	        this.percentSadness = percentSadness;
	    }

	/**
	 * sets the emotions array
	 * @param emotions
	 */
	public void setEmotions(double[] emotions) {
            this.emotions = emotions;
        }
	
	/*
	 * getter for the book object
	 * 
	 * @return book
	 */
	public Book getBook() {
		return this.book;
	}
	
	
}
