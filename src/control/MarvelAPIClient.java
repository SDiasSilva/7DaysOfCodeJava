package control;

import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MarvelAPIClient implements APIClient {
	private String apiKey;
	private String ts;
	private String hash;

	public MarvelAPIClient(String ts, String privKey, String pubKey) {
		this.ts = ts;
		this.apiKey = pubKey;
		try {
			this.hash = getMD5(ts + privKey + pubKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBody() {
		HttpResponse<String> response = makeAPIRequest("https://gateway.marvel.com:443/v1/public/comics?limit=100&ts="
				+ ts + "&apikey=" + apiKey + "&hash=" + hash);
		return response.body();
	}

	private String getMD5(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
			hexString.append(String.format("%02x", b & 0xff));
		}
		return hexString.toString();
	}
}
