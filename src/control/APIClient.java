package control;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public interface APIClient {
	public String getBody();

	default HttpResponse<String> makeAPIRequest(String apiURL) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = null;
		HttpResponse<String> response = null;
		try {
			request = HttpRequest.newBuilder().uri(new URI(apiURL)).GET().build();
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException | InterruptedException | URISyntaxException e) {
			e.printStackTrace();
		}
		return response;
	}
//	public Type type();
}
