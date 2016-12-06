
import java.net.*;
import java.io.*;

public class Test {


	public static void main(String[] args) throws Exception {

        URL goodReads = new URL("https://www.goodreads.com/book/title.json?key=E3ZcRVMjy7JorZ2b4et2fQ&title=Moby+Dick");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(goodReads.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
