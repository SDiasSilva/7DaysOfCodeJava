package control;

import java.util.List;
import com.google.gson.Gson;
import model.ImdbMovie;

public class ImdbMovieJsonParser implements JsonParser {
	private String json;

	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}

	@Override
	public List<ImdbMovie> parse() {
		Gson gson = new Gson();
		ImdbTop250Movies top250 = gson.fromJson(json, ImdbTop250Movies.class);
		return top250.items;
	}

	private class ImdbTop250Movies {
		List<ImdbMovie> items;
	}
}
