package control;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {
	private HttpClient client;
	private HttpRequest request;
	private HttpResponse<String> response;
	private String apiKey;
	
	public ImdbApiClient(String apiKey){
		this.apiKey = apiKey;
	}
	
	public String getBody(){
		client = HttpClient.newHttpClient();
		try {
			request = HttpRequest.newBuilder()
					.uri(new URI(apiKey)).GET().build();
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
		}
		return response.body();
	}
}
