package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions.Builder;

public class EmotionAnalyser {
	private static ToneAnalyzer service;

//	private ToneAnalysis tone;
//	private ElementTone docTone;
	
	EmotionAnalyser() {
		// initialize analyzer
		this.service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		
		// set api keys
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");

	}
	
	
	/**
	 * This is a static method.
	 * It takes a string of text and creates a document tone.
	 * @param text
	 */
	public static ElementTone toneGenerator(String text) {
		//set the tone options to only display emotions
		Tone emotions = Tone.EMOTION;
		Builder toneBuilder = new Builder();
		ToneOptions options = toneBuilder.addTone(emotions).build();
		// Call the service and get the tone
		ToneAnalysis tone = service.getTone(text, options).execute();
		ElementTone docTone = tone.getDocumentTone();
		return docTone;
		
	}


//	/**
//	 * @return the docTone
//	 */
//	public ElementTone getDocTone() {
//		return docTone;
//	}
	
	

}
