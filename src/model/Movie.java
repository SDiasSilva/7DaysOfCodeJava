package model;

public class Movie {
	private final String title;
	private String urlImage;
	private String rating;
	private final String year;

	public Movie(String title, String urlImage, String rating, String year) {
		this.title = title;
		this.urlImage = urlImage;
		this.setRating(rating);
		this.year = year;
	}

	public String getTitle() {
		return this.title;
	}
	
	public String getUrlImage() {
		return this.urlImage;
	}

	public String getRating() {
		return this.rating;
	}

	public String getYear() {
		return this.year;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "\nTítulo: "+getTitle()+"\nAno: "+getYear()+"\nNota: "+getRating()+"\nUrl da Imagem: "+getUrlImage();
	}
}
