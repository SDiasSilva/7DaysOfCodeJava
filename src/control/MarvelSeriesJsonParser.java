package control;

import java.util.List;
import com.google.gson.Gson;
import model.MarvelSeries;

public class MarvelSeriesJsonParser implements JsonParser {
	String json;

	public MarvelSeriesJsonParser(String json) {
		this.json = json;
	}

	@Override
	public List<MarvelSeries> parse() {
		Gson gson = new Gson();
		SeriesDataWrapper marveltop100Series = gson.fromJson(json, SeriesDataWrapper.class);
		System.out.println(marveltop100Series.code);
		return marveltop100Series.data.results;
	}

	private class SeriesDataWrapper {
		String code;
		SeriesDataContainer data;

		private class SeriesDataContainer {
			List<MarvelSeries> results;
		}
	}
}