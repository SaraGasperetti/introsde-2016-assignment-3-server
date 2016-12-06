package introsde.assignment.endpoint;
import introsde.assignment.soap.PeopleImpl;

import javax.xml.ws.Endpoint;

public class PeoplePublisher {
	public static String SERVER_URL = "http://localhost";
	public static String PORT = "6902";
	public static String BASE_URL = "/soap/people";
	
	public static String getEndpointURL() {
		return SERVER_URL+":"+PORT+BASE_URL;
	}
 
	public static void main(String[] args) {
		String endpointUrl = getEndpointURL();
		System.out.println("Starting People Service...");
		System.out.println("--> Published at = "+endpointUrl);
		Endpoint.publish(endpointUrl, new PeopleImpl());
    }
}

