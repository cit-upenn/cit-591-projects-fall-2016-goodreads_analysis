package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions.Builder;

public class EmotionAnalyser {
	private ToneAnalysis tone;
	private ElementTone docTone;
	
	
	public EmotionAnalyser(String text) {
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");

		//set the tone options to only display emotions
		Tone emotions = Tone.EMOTION;
		Builder toneBuilder = new Builder();
		ToneOptions options = toneBuilder.addTone(emotions).build();
		
		// Call the service and get the tone
		tone = service.getTone(text, options).execute();
		docTone = tone.getDocumentTone();
		
	}


	/**
	 * @return the docTone
	 */
	public ElementTone getDocTone() {
		return docTone;
	}
	
	

}
