package API;

public abstract class APICaller implements APIAccess {
	
	private final String APIKey;
	private final String APIName;
	private final String APIURLBase;
	
	
	public APICaller() {
		
	}
	
	
	
	
	
	
	/*
	 * makes an 
	 */
	private String finalizeAPIcall(String callConfig) {
		return APIURLBase + callConfig;
	}
	
	
	
	
	
	
	
	
}
