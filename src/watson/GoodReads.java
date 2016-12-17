package watson;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoodReads {
	private final String API_BASE = "https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=";
	private ArrayList<String> reviewContents;
	
	public GoodReads(Book book, int reviewCount) throws IOException{
		String url = buildUrl(book.getTitle());
	
		Document response = Jsoup.connect(url).get();
		
		GRParser parser = new GRParser(response, reviewCount);
		
		reviewContents = parser.getContent();
		
		ReviewGenerator rg = new ReviewGenerator(reviewContents, book);
		
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
