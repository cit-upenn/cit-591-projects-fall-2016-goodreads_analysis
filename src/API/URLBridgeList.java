package API;

import java.io.IOException;
import java.util.ArrayList;

public interface URLBridgeList {
	
	/*
	 * gets a list of URLs from a given page. 
	 * 
	 * @param sourceURL -- string URL to find desired links
	 */
	ArrayList<String> getURLBridges(String SourceURL) throws IOException;
}
