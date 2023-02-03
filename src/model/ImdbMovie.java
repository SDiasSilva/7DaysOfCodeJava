package model;

public class ImdbMovie implements Content, Comparable<Content> {
	private String title;
	private String image;
	private String imDbRating;
	private String year;

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
		return "\nTítulo: " + title() + "\nAno: " + year() + "\nNota: " + rating() + "\nUrl da Imagem: " + urlImage();
	}

	@Override
	public String type() {
		return "Movie";
	}

	@Override
	public int compareTo(Content outro) {
		return this.title().compareTo(outro.title());
	}
	

}
