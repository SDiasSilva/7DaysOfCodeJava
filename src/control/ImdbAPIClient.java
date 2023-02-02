package control;

import java.net.http.HttpResponse;

public class ImdbAPIClient implements APIClient{
	private String apiKey;
	
	public ImdbAPIClient(String apiKey){
		this.apiKey = apiKey;
	}
	
	@Override
	public String getBody(){
		 HttpResponse<String> response = makeAPIRequest("https://imdb-api.com/en/API/Top250Movies/" + apiKey);
	        return response.body();
	}
}
