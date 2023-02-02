package control;

import java.util.List;
import com.google.gson.Gson;
import model.MarvelComic;

public class MarvelComicJsonParser implements JsonParser {
	String json;

	public MarvelComicJsonParser(String json) {
		this.json = json;
	}

	@Override
	public List<MarvelComic> parse() {
		Gson gson = new Gson();
		ComicDataWrapper marvel100Comic = gson.fromJson(json, ComicDataWrapper.class);
		System.out.println(marvel100Comic.code);
		return marvel100Comic.data.results;
	}

	private class ComicDataWrapper {
		String code;
		ComicDataContainer data;

		private class ComicDataContainer {
			List<MarvelComic> results;
		}
	}
}
