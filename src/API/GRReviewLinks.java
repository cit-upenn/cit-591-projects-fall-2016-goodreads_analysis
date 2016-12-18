package API;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GRReviewLinks implements URLBridgeList {
	private static String contentClassName;
	
	public GRReviewLinks () {
		this.contentClassName = "gr_more_link";
	}
	
	/*
	 * (non-Javadoc)
	 * @see API.URLBridgeList#getURLBridges(java.lang.String)
	 */
	@Override
	public ArrayList<String> getURLBridges (String sourceURL) throws IOException {
		
		Document contentBridge = Jsoup.connect(sourceURL).get();
		
		// get content id addresses 
		Elements bridges = contentBridge.getElementsByClass(this.contentClassName);
		
		// make list for the review addresses
		ArrayList<String> contentURLStrings = new ArrayList<>();
		
		// get Content URLs from href tags
		for (Element elem : bridges) {
			System.out.println(elem);
			contentURLStrings.add( elem.attr("abs:href"));
		}
		
		return contentURLStrings;
		
		
	}
	
}
