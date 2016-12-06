
package goodreads;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class GoodreadsApi extends DefaultApi10a {
		
	private final static String API_BASE = "https://www.goodreads.com/api/"; 
//	private final static String API_BASE = "https://www.goodreads.com/search.xml?key=&q=Ender%27s+Game"; 

	private final static String MY_KEY = "KoJ8Ke462QB084zyF4yrXQ";
	private final static String MY_SECRET = "5YK7VkixXeEI28VuV9QIJz7bKbXy4zv0RVKedCk5Q";
		    

	@Override
	public String getAccessTokenEndpoint() {
		return "http://www.goodreads.com/oauth/access_token";
	}

	@Override
	public String getRequestTokenEndpoint() {
		return "http://www.goodreads.com/oauth/request_token";
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return String.format(API_BASE, requestToken.getToken());
	}
}
