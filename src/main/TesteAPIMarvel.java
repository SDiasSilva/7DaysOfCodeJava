package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import control.HttpGenerator;
import control.MarvelAPIClient;
import control.MarvelComicJsonParser;
import model.MarvelComic;

public class TesteAPIMarvel {
	public static void main(String[] args) throws FileNotFoundException {
		// #7DayOfCode - Dia 6 - Utilização de Interfaces para abstrair o código e utilizando em outra API
		Scanner scanner = new Scanner(System.in);
		System.out.print("Timestamp: ");
		String ts = scanner.nextLine();
		System.out.print("Marvel Private API Key: ");
		String privKey = scanner.nextLine();
		System.out.print("Marvel Public API Key: ");
		String pubKey = scanner.nextLine();

		String json = new MarvelAPIClient(ts, privKey, pubKey).getBody();

		List<MarvelComic> marvelComics = new MarvelComicJsonParser(json).parse();

		marvelComics.forEach(System.out::println);

		new HttpGenerator(new PrintWriter("marvelComics.html")).generate(marvelComics);
	}
}
