package API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TextFinder {
	private String widgetSourceURL;
	private String widgetFinder;
	private Pattern matchWidget;
	private ArrayList<String> textBodies;
	
	
	
	TextFinder() {

		
        try {
			Document doc = Jsoup.connect(this.widgetSourceURL).get();
			
			
		} catch (IOException e) {
			// TODO: NO FILE FOUND RESPONSE
			e.printStackTrace();
		}

		
	}
	
	
	
}
