package watson;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoodReads {
	private final String API_BASE = "https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=";
	
	
	public GoodReads(Book book) throws IOException{
		String url = buildUrl(book.getTitle());
		
	
		Document response = Jsoup.connect(url).get();
		
		
		Document now = Jsoup.parse(response.getElementsByTag("reviews_widget").text());
		
		// get Bridge URL
		String bridgeURL = now.getElementById("the_iframe").absUrl("src");
		bridgeURL += bridgeURL + "&num_reviews=10";
		
		// go to content link site
		Document contentBridge = Jsoup.connect(bridgeURL).get();
				
		// get content id addresses 
		// TODO make class name an instance variable
		Elements bridges = contentBridge.getElementsByClass("gr_more_link");
				
		// make list for the review addresses
		ArrayList<String> contentURLStrings = new ArrayList<>();
		
		// get Content URLs from href tags
		for (Element elem : bridges) {
			contentURLStrings.add(elem.attr("abs:href"));
			}
				
		ArrayList<String> content = new ArrayList<>();
		Document contentDoc = null;
		
		for (String each : contentURLStrings) {
			// connect to URl
			contentDoc = Jsoup.connect(each).get();
			
			// get content element
	        Elements review = contentDoc.getElementsByClass("reviewText mediumText description readable");
	        
	        // get content string
	        content.add(review.get(0).text());
		}
		
		for (String each : content ) {
        	Review review = new Review(each);
        	book.addReview(review);
        }
	}
	
	
	
	/**
	 * This method takes a book title, splits it into an array of words, 
	 * and appends it to the API Base.
	 * @param title the book title
	 * @return the url to call goodreads
	 */
	private String buildUrl(String title) { 
		String[] words = title.split("\\s+");
	
		StringBuilder url = new StringBuilder(API_BASE);
			for (String word : words) { 
				url.append(word + "+"); 
				}
			url.setLength(url.length() - 1);
			return url.toString();
			}

}
