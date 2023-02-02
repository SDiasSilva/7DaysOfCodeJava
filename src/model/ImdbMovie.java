package model;

public class ImdbMovie implements Content{
	private final String title;
	private String image;
	private String imDbRating;
	private final String year;

	public ImdbMovie(String title, String image, String imDbRating, String year) {
		this.title = title;
		this.image = image;
		this.imDbRating = imDbRating;
		this.year = year;
	}

	@Override
	public String title() {
		return this.title;
	}

	@Override
	public String urlImage() {
		return this.image;
	}

	@Override
	public String rating() {
		return this.imDbRating;
	}

	@Override
	public String year() {
		return this.year;
	}

	@Override
	public String toString() {
		return "\nTítulo: " + title() + "\nAno: " + year() + "\nNota: " + rating() + "\nUrl da Imagem: "
				+ urlImage();
	}
}
