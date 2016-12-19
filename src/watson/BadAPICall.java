package watson;

public class BadAPICall extends Exception {
	

	@Override
	public String getMessage() {
		return "The book name you entered was not found";
	}
	
}
