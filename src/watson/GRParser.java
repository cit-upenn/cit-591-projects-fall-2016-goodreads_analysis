package watson;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This is the GRParser Class.
 * It parses the goodreads response into individual strings of reviews
 * @author carsonstack
 *
 */
public class GRParser {
	ArrayList<String> content;

	/**
	 * This is the constructor method.
	 * It takes the goodreads response and creates an arraylist made up of a string for each review
	 * @param text The original response from the GoodRead API
	 * @param reviewCount How many reviews to extract
	 * @throws IOException
	 */
	public GRParser(Document text, int reviewCount) throws IOException{
		
		Document now = Jsoup.parse(text.getElementsByTag("reviews_widget").text());
		
		// get Bridge URL
		String bridgeURL = now.getElementById("the_iframe").absUrl("src");
		bridgeURL += bridgeURL + "&num_reviews=" + reviewCount;
		
		// go to content link site
		Document contentBridge = Jsoup.connect(bridgeURL).get();
				
		// get content id addresses 
		Elements bridges = contentBridge.getElementsByClass("gr_more_link");
				
		// make list for the review addresses
		ArrayList<String> contentURLStrings = new ArrayList<>();
		
		// get Content URLs from href tags
		for (Element elem : bridges) {
			contentURLStrings.add(elem.attr("abs:href"));
			}
				
		content = new ArrayList<>();
		Document contentDoc = null;
		
		for (String each : contentURLStrings) {
			// connect to URl
			contentDoc = Jsoup.connect(each).get();
			
			// get content element
	        Elements review = contentDoc.getElementsByClass("reviewText mediumText description readable");
	        
	        // get content string
	        content.add(review.get(0).text());
		}
	
	}
	
	/**
	 * This is a getter method for the content parsed.
	 * @return content
	 */
	public ArrayList<String> getContent(){
		return content;
	}
}
