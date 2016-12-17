package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;

public class ToneParser {
	private String [] strings;
	
	public ToneParser(ElementTone tone){
		//put tone into string
		String toneString = tone.toString();
				
		//remove whitespace
		String singleLine = toneString.replaceAll("\\s+", "");
				
		//create array of strings for each emotion
		strings = singleLine.split("}");
		
	}
	
	public double returnAnger(){
		String anger = strings[0].replaceAll("[^0-9.]", "");
		double angerDouble = Double.parseDouble(anger);
		return angerDouble;
	}
	
	public double returnDisgust(){
		String disgust = strings[1].replaceAll("[^0-9.]", "");
		double disgustDouble = Double.parseDouble(disgust);
		return disgustDouble;
	}
	
	public double returnFear(){
		String fear = strings[2].replaceAll("[^0-9.]", "");
		double fearDouble = Double.parseDouble(fear);
		return fearDouble;
	}
	
	public double returnJoy(){
		String joy = strings[3].replaceAll("[^0-9.]", "");
		double joyDouble = Double.parseDouble(joy);
		return joyDouble;
	}
	
	public double returnSadness(){
		String sadness = strings[2].replaceAll("[^0-9.]", "");
		double sadnessDouble = Double.parseDouble(sadness);
		return sadnessDouble;
	}
	
}
