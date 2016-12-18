package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

/**
 * This is the Review class.
 * Each review has text, a tone, and individual emotion scores.
 * @author carsonstack
 *
 */
public class Review {
	private String text;
	private ElementTone tone;
	private double anger;
	private double disgust;
	private double fear;
	private double joy;
	private double sadness;
	
	
	/**
	 * This is the constructor method.
	 * It takes in the text of the review and assigns emotional scores.
	 * @param text
	 */
	public Review(String text) {
		this.text = text;
		tone = EmotionAnalyser.toneGenerator(text);
		ToneParser tp = new ToneParser(tone);
		anger = tp.returnAnger();
		disgust = tp.returnDisgust();
		fear = tp.returnFear();
		joy = tp.returnJoy();
		sadness = tp.returnSadness();
	}
	
	
	

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the anger
	 */
	public double getAnger() {
		return anger;
	}

	/**
	 * @return the disgust
	 */
	public double getDisgust() {
		return disgust;
	}

	/**
	 * @return the fear
	 */
	public double getFear() {
		return fear;
	}

	/**
	 * @return the joy
	 */
	public double getJoy() {
		return joy;
	}

	/**
	 * @return the sadness
	 */
	public double getSadness() {
		return sadness;
	}

}
