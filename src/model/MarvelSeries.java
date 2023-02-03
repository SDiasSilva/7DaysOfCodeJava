package model;

public class MarvelSeries extends AbstractMarvel {
	private int startYear;
	private String rating;
	
	@Override
	public String title() {
		return super.title();
	}
	
	@Override
	public String urlImage() {
		return super.urlImage();
	}
	
	@Override
	public String rating() {
		if(this.rating.isBlank()) {
			return "Vazio";
		}
		return this.rating;
	}

	@Override
	public String year() {
		return ""+this.startYear;
	}
	
	@Override
	public String toString() {
	  return super.toString();
	}
	
	@Override
	public String type() {
		return "Series";
	}
	
	@Override
	public int compareTo(Content outro) {
		return this.title().compareTo(outro.title());
	}
}
