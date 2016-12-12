package API;

public interface APIAccess {
	
	/*
	 * retrieves the name of the API
	 * 
	 * @return String -- name of the API that the object accesses
	 */
	public String getAPIName();
	
	/*
	 * configures the API call for a given API 
	 * 
	 * @param string reresenting the parameters of the call
	 */
	public String configureAPICall(String parameters);
	
	/*
	 * Return the base API URL string 
	 * 
	 * @return String -- base URL for the API Call
	 */
	public String getAPIBase();
	
}
