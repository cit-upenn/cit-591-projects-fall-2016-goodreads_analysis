package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class Review {
	private String text;
	private ToneAnalysis tone;
	
	public Review(String text) {
		this.text = text;
		EmotionAnalyser watson = new EmotionAnalyser(text);
		tone = watson.getTone();
	}
	
}
