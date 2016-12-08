package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class EmotionAnalyser {
	private ToneAnalysis tone;
	
	public EmotionAnalyser(String text) {
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");

		// Call the service and get the tone
		tone = service.getTone(text, null).execute();
	}

	/**
	 * @return the tone
	 */
	public ToneAnalysis getTone() {
		return tone;
	}
	
	
	

}
