package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class Review {
	private String text;
	private double anger;
	private double disgust;
	private double fear;
	private double joy;
	private double sadness;
	
	public Review(String text) {
		this.text = text;
		EmotionAnalyser watson = new EmotionAnalyser(text);
		anger = watson.getAnger();
		disgust = watson.getDisgust();
		fear = watson.getFear();
		joy = watson.getJoy();
		sadness = watson.getSadness();
	}
	
}
