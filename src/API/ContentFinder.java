package API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ContentFinder {
	private String searchinput;
	private APIAccessor API;
	private String bridgeURL;
	private String widgetFinder;
	private Pattern matchWidget;
	private ArrayList<String> textBodies;
	
	
	
	TextFinder(String bookName) {

		
		
        try {
			Document doc = Jsoup.connect(this.widgetSourceURL).get();
	        Elements widgetAddress = doc.getElementsByClass("reviewText mediumText description readable");

			
			
		} catch (IOException e) {
			// TODO: NO FILE FOUND RESPONSE
			e.printStackTrace();
		}

		
	}
	
	
	public String getBridgeURL() {
		
	}
	
	
	
	
	
	
	
	
	
}
