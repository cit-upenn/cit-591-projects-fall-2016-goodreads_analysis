
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class OlderRunServer {
	public static void main(String args[]) throws IOException  {
//        URL goodReads = new URL("https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=Moby+Dick");
//        BufferedReader in = new BufferedReader(
//        new InputStreamReader(goodReads.openStream()));
//
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
////            System.out.println(inputLine);
//        in.close();
        
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        Document doc = db.parse(new URL("https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=Moby+Dick").openStream());
//        
//        System.out.println(doc);
//        
//        TransformerFactory factory = TransformerFactory.newInstance();
//        Transformer xform = factory.newTransformer();
//
//        // that’s the default xform; use a stylesheet to get a real one
//        xform.transform(new DOMSource(doc), new StreamResult(System.out));
//        
//        XMLReader myReader = XMLReaderFactory.createXMLReader();
//        myReader.setContentHandler(null);
//        myReader.parse(new InputSource(new URL("https://www.goodreads.com/review/show/161695047").openStream()));
        
		// 
        Document rev = Jsoup.connect("https://www.goodreads.com/book/title.xml?key=E3ZcRVMjy7JorZ2b4et2fQ&title=Moby+Dick").get();
		
		System.out.println(rev.getElementsByTag("reviews_widget").toString());
		
		// match everything in quotes
		Pattern matchWidget = Pattern.compile("\"(.*?)\"");
		
		// create matcher for to find the URL where that contains links to the content pages
		Matcher m = matchWidget.matcher((CharSequence) rev.getElementsByTag("reviews_widget").toString());
		
		String bridgeURL = null;
		
		// Get the URL to find next link
		while (m.find()) {
			// if matched string contains the URL of the iframe (contains string "iframe"), store URL string and exit
			if (m.group(1).contains("widget_iframe")) {
				bridgeURL = m.group(1);
				break;
			}
			
		}
		
		// go to content link site
		Document contentBridge = Jsoup.connect(bridgeURL).get();
		
		// get content id addresses 
		// TODO make class name an instance variable
		Elements bridges = contentBridge.getElementsByClass("gr_more_link");
		
		// make list for the review addresses
		ArrayList<String> contentURLStrings = new ArrayList<>();
		
		// get Content URLs from href tags
		for (Element elem : bridges) {
			System.out.println(elem);
			contentURLStrings.add( elem.attr("abs:href"));
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
        	System.out.println(each);
        }
        
        
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");


		 Call the service and get the tone
		ToneAnalysis tone = null;
        for (Element elem: review ) {
        	tone = service.getTone(elem.text(), null).execute();
        }
		System.out.println(tone.getDocumentTone());
		
	}
}
