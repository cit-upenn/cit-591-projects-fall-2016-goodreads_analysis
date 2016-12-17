package watson;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoodReads {
	private final String API_BASE = "https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=";
	
	
	public GoodReads(Book book){
		String url = buildUrl(book.getTitle());
		
		try {
			Document response = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
