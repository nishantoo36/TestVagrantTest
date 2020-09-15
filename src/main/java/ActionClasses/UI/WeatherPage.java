package ActionClasses.UI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import static ActionClasses.Comparator.jsonObjectForUI;
import utility.SeleniumUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherPage extends SeleniumUtility {

    public WeatherPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindAll(value = {@FindBy(xpath = "//div[@class='message' and not(@style='display: none;')]//child::input")})
    List<WebElement> citySearchData;

    @FindAll(value = {@FindBy(className = "cityText")})
    List<WebElement> citiesOnMap;

    @FindBy(className = "leaflet-popup-content")
    WebElement weatherDetailsPopup;

    @FindBy(xpath = "//div[@class='leaflet-popup-content']//child::span[not(@class='heading')and(string-length(text()) > 0)]")
    WebElement cityAndStatedata;

    private static String weatherDataForCity;

    List<String> cityData = new ArrayList<>(Arrays.asList("Condition", "Wind", "Humidity", "Temp in Degrees", "Temp in Fahrenheit"));

    public boolean isUserOnWeatherPage(String pageTitle, int timeout) throws InterruptedException {
        Thread.sleep(1000);
        return isTitle(pageTitle, timeout);
    }

    public boolean isCityAvailableInSearchList(String city, int timeout)  {
        return getAllElementsAttributeFromElementList(citySearchData, "id", timeout).contains(city);
    }

    public void selectCityFromSearchResult(String city, int timeout) {
        if (isCityAvailableInSearchList(city, timeout)) {
            WebElement ele=  getElementByAttributeTextFromElementList(citySearchData, "id", city, 0);
            if(!ele.isSelected()){
                clickOnElement(ele,0);
            }
        }
    }

    public void enterCityInSearch(String city) {
        clearAndEnterValue(searchBox, city, 10);
    }

    public boolean isCityAppearsOnMap(String city, int timeout){
        return getAllElementsTextFromElementList(citiesOnMap, timeout).contains(city);
    }

    public boolean isCityWeatherDataAppearsAfterClickingOnTheCity(String city, int timeout)  {
        if (isElementAvailable(weatherDetailsPopup, 1)) {
            weatherDataForCity = getText(weatherDetailsPopup, 1);
            cityData.add(0, city);
            for (String data : cityData) {
                if (!weatherDataForCity.contains(data)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void clickOnTheCity(String city) {
        clickOnElement(getElementByTextFromElementList(citiesOnMap, city, 0), 0);
    }

    public void storeWeatherDataForCity(String city){
        weatherDataForCity = weatherDataForCity.replaceAll(getText(cityAndStatedata,0)+"\n","");
        String [] weatherData= weatherDataForCity.split("\n");
        int val = weatherData.length;
        int temp = 0;
        while (temp<val){
            String []tempSplit = weatherData[temp].split(":");
            jsonObjectForUI.addProperty(tempSplit[0],tempSplit[1]);
            temp++;
        }
    }
}
