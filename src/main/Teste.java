package main;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Movie;

public class Teste {
	public static void main(String[] args) throws Exception {
		//#7DayOfCode - Dia 1 -  Fazer uma chamada na API do IMDB e recuperar o conteúdo
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("url ocultada")).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body().replace("{\"items\":[", "").replace("],\"errorMessage\":\"\"}", "")
				.replace("{", "\n").replace("},", ",").replace("}", "");
//		System.out.println(body);

		//#7DayOfCode - Dia 2 -  Parsear o conteúdo
		List<String> list = Arrays.asList(body.split("\",\""));
		List<String> ids = parseAtribute(list, "id\"");
		List<String> ranks = parseAtribute(list, "rank\"");
		List<String> titles = parseAtribute(list, "title\"");
		List<String> fullTitles = parseAtribute(list, "fullTitle\"");
		List<String> years = parseAtribute(list, "year\"");
		List<String> urlImages = parseAtribute(list, "image\"");
		List<String> crews = parseAtribute(list, "crew\"");
		List<String> ratings = parseAtribute(list, "imDbRating\"");
		List<String> ratingCounts = parseAtribute(list, "imDbRatingCount\"");
		System.out.println(ids.size());
		System.out.println(ranks.size());
		System.out.println(titles.size());
		System.out.println(fullTitles.size());
		System.out.println(years.size());
		System.out.println(urlImages.size());
		System.out.println(crews.size());
		System.out.println(ratings.size());
		System.out.println(ratingCounts.size());
//		crews.forEach(System.out::println);
		
		//#7DayOfCode - Dia 3 -  Modelar a Classe Movie e instanciar uma lista para armazenar o conteúdo do dia anterior
		List<Movie> movies = new ArrayList<Movie>();
		for(int index = 0; index < titles.size(); index++) {
			movies.add(new Movie(titles.get(index), urlImages.get(index), ratings.get(index), years.get(index)));
		}
		movies.forEach(System.out::println);
	}

	public static List<String> parseAtribute(List<String> originalList, String keyword) {
		List<String> extractedList = new ArrayList<String>();
		originalList.forEach(item -> {
			if (item.contains(keyword)) {
				extractedList.add(item.replace(keyword, "").replace(":", "").replace("\"", ""));
			}
		});
		return extractedList;
	}
}
