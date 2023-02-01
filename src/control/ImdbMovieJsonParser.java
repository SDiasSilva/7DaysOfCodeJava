package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Movie;

public class ImdbMovieJsonParser {
	private String json;

	public ImdbMovieJsonParser(String json) {
		this.json = json;
	}

	public List<Movie> parse() {
		json.replace("{\"items\":[", "").replace("],\"errorMessage\":\"\"}", "").replace("{", "\n").replace("},", ",")
				.replace("}", "");
		List<String> list = Arrays.asList(json.split("\",\""));
		List<String> titles = parseAtribute(list, "title\"");
		List<String> years = parseAtribute(list, "year\"");
		List<String> urlImages = parseAtribute(list, "image\"");
		List<String> ratings = parseAtribute(list, "imDbRating\"");
		List<Movie> movies = new ArrayList<Movie>();
		for (int index = 0; index < titles.size(); index++) {
			movies.add(new Movie(titles.get(index), urlImages.get(index), ratings.get(index), years.get(index)));
		}
		movies.forEach(movie -> movie.setUrlImage(movie.getUrlImage().replace("https", "https:")));
		return movies;
	}

	private List<String> parseAtribute(List<String> originalList, String keyword) {
		List<String> extractedList = new ArrayList<String>();
		originalList.forEach(item -> {
			if (item.contains(keyword)) {
				extractedList.add(item.replace(keyword, "").replace(":", "").replace("\"", ""));
			}
		});
		return extractedList;
	}
}
