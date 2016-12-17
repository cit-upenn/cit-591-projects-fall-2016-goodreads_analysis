package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ElementTone;


/**
 * This is the ToneParser class.
 * It parses an ElementTone and extracts the individual emotion scores.
 * @author carsonstack
 *
 */
public class ToneParser {
	private String [] strings;
		
	/**
	 * This is the constructor method.
	 * It changes the tone result to a string, removes whitespace,
	 * and breaks it into a different string for each emotion
	 * @param tone
	 */
	public ToneParser(ElementTone tone){
		//put tone into string
		String toneString = tone.toString();		
		//remove whitespace
		String singleLine = toneString.replaceAll("\\s+", "");		
		//create array of strings for each emotion
		strings = singleLine.split("}");
	}
	
	/**
	 * This extracts the value of anger from the string
	 * @return the value of anger as a double
	 */
	public double returnAnger(){
		String anger = strings[0].replaceAll("[^0-9.]", "");
		double angerDouble = Double.parseDouble(anger);
		return angerDouble;
	}
	
	/**
	 * This extracts the value of disgust from the string
	 * @return the value of disgust as a double
	 */
	public double returnDisgust(){
		String disgust = strings[1].replaceAll("[^0-9.]", "");
		double disgustDouble = Double.parseDouble(disgust);
		return disgustDouble;
	}
	
	/**
	 * This extracts the value of fear from the string
	 * @return the value of fear as a double
	 */
	public double returnFear(){
		String fear = strings[2].replaceAll("[^0-9.]", "");
		double fearDouble = Double.parseDouble(fear);
		return fearDouble;
	}
	
	/**
	 * This extracts the value of joy from the string
	 * @return the value of joy as a double
	 */
	public double returnJoy(){
		String joy = strings[3].replaceAll("[^0-9.]", "");
		double joyDouble = Double.parseDouble(joy);
		return joyDouble;
	}
	
	/**
	 * This extracts the value of sadness from the string
	 * @return the value of sadness as a double
	 */
	public double returnSadness(){
		String sadness = strings[2].replaceAll("[^0-9.]", "");
		double sadnessDouble = Double.parseDouble(sadness);
		return sadnessDouble;
	}
	
}
