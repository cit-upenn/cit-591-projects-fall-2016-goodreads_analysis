package API;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GRReviewURLBridge implements URLBridge {

	@Override
	public String getURL(String SourceURL) throws IOException {
		
		// Get the content from the source URL
		Document apiResponse = Jsoup.connect(SourceURL).get();
		
		// get reviews widget URL
		Document now = Jsoup.parse(apiResponse.getElementsByTag("reviews_widget").text());		

		// get Bridge URL
		String bridgeURL = now.getElementById("the_iframe").absUrl("src");
		
		//return Bridge URL
		return bridgeURL;
		
	}
	
	
	
	
	
}
