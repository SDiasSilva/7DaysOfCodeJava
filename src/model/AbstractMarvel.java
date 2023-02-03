package model;

public abstract class AbstractMarvel implements Content, Comparable<Content>{
	protected String title;
	protected Image thumbnail;

	@Override
	public String title() {
		return this.title;
	}

	@Override
	public String urlImage() {
		return thumbnail.path + "." + thumbnail.extension;
	}

	@Override
	public abstract String rating();

	@Override
	public abstract String year();

	@Override
	public String toString() {
		return "\nTítulo: " + title() + "\nAno: " + year() + "\nNota: " + rating() + "\nUrl da Imagem: " + urlImage();
	}
	
	private class Image {
		String path;
		String extension;
	}
}
