package manager.API;

import ActionClasses.API.CityWeatherData;
import ActionClasses.Comparator;
import ActionClasses.UI.CommonUIActions;
import ActionClasses.UI.WeatherPage;

public class PageObjectMangerAPI {

	public CityWeatherData cityWeatherData;
	public Comparator comparator;

	public CityWeatherData getCityWeatherData() {
		return (cityWeatherData == null) ? cityWeatherData = new CityWeatherData() : cityWeatherData;
	}
	public Comparator getComparator() {
		return (comparator == null) ? comparator = new Comparator() : comparator;
	}


}


