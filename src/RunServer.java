
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

public class RunServer {
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
        
        
        Document doc = Jsoup.connect("https://www.goodreads.com/review/show/161695047").get();
        Elements review = doc.getElementsByClass("reviewText mediumText description readable");
        
        for (Element elem: review ) {
        	System.out.println(elem.text());
        }
        
        
		ToneAnalyzer service = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);
		service.setUsernameAndPassword("92dc16f3-482d-46d0-9f83-4d7d223ad9b1", "vyWzY7PIs37e");


//		 Call the service and get the tone
		ToneAnalysis tone = null;
        for (Element elem: review ) {
        	tone = service.getTone(elem.text(), null).execute();
        }
		System.out.println(tone.getDocumentTone());
		
	}
}
