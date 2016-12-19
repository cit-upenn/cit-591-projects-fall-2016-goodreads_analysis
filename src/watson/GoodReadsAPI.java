package watson;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * This is the GoodReads class.
 * It connects to the GoodReads API and stores the contents of the response.
 * @author carsonstack
 *
 */
public class GoodReadsAPI {
	private static final String API_BASE = "https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=";
	private ArrayList<String> reviewContents;
	
	/**
	 * This is the constructor method.
	 * It builds a URL from the book title.
	 * It calls the GoodReads API with that review.
	 * It creates a GRParser to parse the response and a ReviewGenerator to create Reviews
	 * @param book 
	 * @param reviewCount the number of reviews to consider
	 * @throws IOException
	 * @throws BadAPICall 
	 */
	public GoodReadsAPI(Book book, int reviewCount) throws IOException, BadAPICall{
		
		
		
		String url = buildUrl(book.getTitle());
	
		Document response = Jsoup.connect(url).get();
		
		GRParser parser = new GRParser(response, reviewCount);
		
		reviewContents = parser.getContent();
		
		// set author and title of book to the book found with search
		book.setAuthor(parser.Author);
		book.setTitle(parser.Title);
	
		
		ReviewGenerator.reviewLoader(reviewContents, book);
		
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
