package model;

public class MarvelComic implements Content {
	private String title;
	private Image thumbnail;

	@Override
	public String title() {
		return this.title;
	}

	@Override
	public String urlImage() {
		return thumbnail.path + "." + thumbnail.extension;
	}

	@Override
	public String rating() {
		return "N/A";
	}

	@Override
	public String year() {
		return "N/A";
	}

	@Override
	public String toString() {
		return "\nTítulo: " + title() + "\nAno: " + year() + "\nNota: " + rating() + "\nUrl da Imagem: " + urlImage();
	}

	private class Image {
		String path;
		String extension;
	}
}
