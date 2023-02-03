package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import control.HttpGenerator;
import control.ImdbAPIClient;
import control.ImdbMovieJsonParser;
import control.MarvelAPIClient;
import control.MarvelComicJsonParser;
import control.MarvelSeriesJsonParser;
import model.AbstractMarvel;
import model.Content;
import model.ImdbMovie;
import model.MarvelComic;
import model.MarvelSeries;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// #7DayOfCode - Dia 7 -
		// Chamada na API
		String imdbApiKey = System.getenv("IMDB_API_KEY");
		String marvelPrivKey = System.getenv("MARVEL_PRIVATE_KEY");
		String marvelPubKey = System.getenv("MARVEL_PUBLIC_KEY");
		String jsonImdbMovies = new ImdbAPIClient(imdbApiKey).getBody();
		String jsonMarvelComics = new MarvelAPIClient("1", marvelPrivKey, marvelPubKey,
				"https://gateway.marvel.com:443/v1/public/comics?limit=100").getBody();
		String jsonMarvelSeries = new MarvelAPIClient("1", marvelPrivKey, marvelPubKey,
				"https://gateway.marvel.com:443/v1/public/series?limit=100").getBody();
		// Parseamento do JSON
		List<ImdbMovie> movies = new ImdbMovieJsonParser(jsonImdbMovies).parse();
		List<MarvelComic> marvelComics = new MarvelComicJsonParser(jsonMarvelComics).parse();
		List<MarvelSeries> marvelSeries = new MarvelSeriesJsonParser(jsonMarvelSeries).parse();
		List<? extends Content> mixedList = Stream.of(movies, marvelComics, marvelSeries)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		Collections.sort(mixedList, Comparator.comparing(Content::title).reversed());
		mixedList.forEach(System.out::println);
		new HttpGenerator(new PrintWriter("mixedList.html")).generate(mixedList);
	}
}
