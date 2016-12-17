package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.Tone;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions.Builder;

public class EmotionAnalyser {
	private ToneAnalysis tone;
	private String [] strings;
	
	public EmotionAnalyser(String text) {
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");

		//set the tone options to only display emotions
		Tone emotions = Tone.EMOTION;
		Builder toneBuilder = new Builder();
		ToneOptions options = toneBuilder.addTone(emotions).build();
		
		// Call the service and get the tone
		tone = service.getTone(text, options).execute();
		
		ElementTone document = tone.getDocumentTone();
		
		//put tone into string
		String toneString = document.toString();
		
		//remove whitespace
		String singleLine = toneString.replaceAll("\\s+", "");
		
		//create array of strings for each emotion
		strings = singleLine.split("}");
		
	}

	
	public double getAnger(){
		String anger = strings[0].replaceAll("[^0-9.]", "");
		double angerDouble = Double.parseDouble(anger);
		return angerDouble;
	}
	
	public double getDisgust(){
		String disgust = strings[1].replaceAll("[^0-9.]", "");
		double disgustDouble = Double.parseDouble(disgust);
		return disgustDouble;
	}
	
	public double getFear(){
		String fear = strings[2].replaceAll("[^0-9.]", "");
		double fearDouble = Double.parseDouble(fear);
		return fearDouble;
	}
	
	public double getJoy(){
		String joy = strings[3].replaceAll("[^0-9.]", "");
		double joyDouble = Double.parseDouble(joy);
		return joyDouble;
	}
	
	public double getSadness(){
		String sadness = strings[2].replaceAll("[^0-9.]", "");
		double sadnessDouble = Double.parseDouble(sadness);
		return sadnessDouble;
	}
	
	

}
