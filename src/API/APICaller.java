package API;

public abstract class APICaller implements APIAccess {
	
	private final String APIKey;
	private final String APIName;
	private final String API_Base;
	
	
	public APICaller() {
		APIKey = null;
		APIName = null;
		API_Base = null;
	}
	
	
}
