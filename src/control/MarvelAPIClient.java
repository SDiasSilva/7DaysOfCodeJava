package control;

import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MarvelAPIClient implements APIClient {
	private String apiKey;
	private String ts;
	private String hash;
	private String link;

	public MarvelAPIClient(String ts, String privKey, String pubKey, String link) {
		this.ts = ts;
		this.link = link;
		this.apiKey = pubKey;
		try {
			this.hash = getMD5(ts + privKey + pubKey);
		} catch (Exception e) {
			System.out.println("Algum dos parâmetros não são válidos.");
		}
	}

	@Override
	public String getBody() {
		HttpResponse<String> response = makeAPIRequest(link + "&ts=" + ts + "&apikey=" + apiKey + "&hash=" + hash);
		return response.body();
	}

	public static String getMD5(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
		StringBuilder hexString = new StringBuilder();
		for (byte b : hash) {
			hexString.append(String.format("%02x", b & 0xff));
		}
		return hexString.toString();
	}
}
