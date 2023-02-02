package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import control.HttpGenerator;
import control.ImdbAPIClient;
import control.ImdbMovieJsonParser;
import model.ImdbMovie;

public class Teste {
	public static void main(String[] args) throws FileNotFoundException {
		// #7DayOfCode - Dia 1 - Fazer uma chamada na API do IMDB e recuperar o conteúdo
		Scanner scanner = new Scanner(System.in);
		System.out.print("IMDB API Key: ");
		String apiKey = scanner.nextLine();
		String json = new ImdbAPIClient(apiKey).getBody();// #7DayOfCode - Dia 5 - Encapsulamento da chamada da API
		// #7DayOfCode - Dia 2 - Parsear o conteúdo
		List<ImdbMovie> movies = new ImdbMovieJsonParser(json).parse();// #7DayOfCode - Dia 5 - Encapsulamento do parseamento do Json

		// #7DayOfCode - Dia 3 - Modelar a Classe Movie e instanciar uma lista para armazenar o conteúdo do dia anterior
		movies.forEach(System.out::println);

		// #7DayOfCode - Dia 4 - Gerar um site com lista de filmes
		new HttpGenerator(new PrintWriter("index.html")).generate(movies);
	}
}
