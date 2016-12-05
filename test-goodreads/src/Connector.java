import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Connector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			URL u = new URL("https://www.goodreads.com/book/title.xml?author=Arthur%20Conan%20Doyle&key=E3ZcRVMjy7JorZ2b4et2fQ&title=Hound%20of%20the%20Baskervilles");
			URLConnection connection = u.openConnection();
			
			Scanner in = new Scanner(connection.getInputStream());
			
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
