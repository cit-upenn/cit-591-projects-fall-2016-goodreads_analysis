package watson;

import com.ibm.watson.developer_cloud.tone_analyzer.*;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.*;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.*;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;

import java.io.File;
import java.util.List;

public class ToneCat {

	ToneAnalyzer service;
	
	public static String parseAndReturn(ToneAnalysis str) {
		String returnStr = "";

		ElementTone docTone = str.getDocumentTone();
		returnStr += "";
		{
			List<ToneCategory> toneCatList = docTone.getTones();
			for (ToneCategory toneCategory : toneCatList) {
				returnStr += "\n\n\n<h3><i>" + toneCategory.getName() + "</i></h3><br/><table>";
				List<ToneScore> toneList = toneCategory.getTones();
				for (ToneScore toneScore : toneList) {
					returnStr += "\n\n<tr>";
					toneScore.getName();
					Double d = toneScore.getScore() * 100;
					String strDouble = String.format("%05.2f", d);
					String name = String.format("%-16s", toneScore.getName());
					returnStr += "\n<td>" + name + "</td>";
					returnStr += "\t<td>" + strDouble + "%" + "</td></tr>";
				}
				returnStr += "</table></br>";
			}
		}
		return returnStr;

	}
	
	public static void main(String[] args){
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");
//		public final String username = "92dc16f3-482d-46d0-9f83-4d7d223ad9b1";
//		public final String password = "vyWzY7PIs37e";
		
		String text =
		  "I know the times are difficult! Our sales have been "
		      + "disappointing for the past three quarters for our data analytics "
		      + "product suite. We have a competitive data analytics product "
		      + "suite in the industry. But we need to do our job selling it! "
		      + "We need to acknowledge and fix our sales challenges. "
		      + "We can’t blame the economy for our lack of execution! "
		      + "We are missing critical sales opportunities. "
		      + "Our product is in no way inferior to the competitor products. "
		      + "Our clients are hungry for analytical tools to improve their "
		      + "business outcomes. Economy has nothing to do with it.";

		// Call the service and get the tone
		ToneAnalysis tone = service.getTone(text, null).execute();
//		System.out.println(tone);
		System.out.println(tone.getDocumentTone());
	}

}