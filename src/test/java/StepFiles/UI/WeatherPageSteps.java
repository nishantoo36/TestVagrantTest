package StepFiles.UI;

import ActionClasses.UI.WeatherPage;
import StepFiles.Logging;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;

public class WeatherPageSteps extends Logging {

    TestContext testContext;
    WeatherPage weatherPage;

    public WeatherPageSteps(TestContext context) {
        testContext = context;
        weatherPage = testContext.getPageObjectMangerUI().getWeatherPage();
    }

    @Then("^user should see the weather page title \"([^\"]*)\"$")
    public void userShouldSeeTheWeatherPageTitle(String pageTitle) {
        log("Verify that user is on " + pageTitle + " page");
        Assert.assertTrue(weatherPage.isUserOnWeatherPage(pageTitle,30), "Verification failed, user is not on the " + pageTitle);
        log("Verification pass successfully , user is on " + pageTitle + " page");

    }

    @When("^user search for \"([^\"]*)\" in Pin your city search$")
    public void userSearchForInPinYourCitySearch(String city)  {
        log("Search the city "+city+" in PIN your city search");
        weatherPage.enterCityInSearch(city);
        log("Searched city as "+city+" in PIN your city searched");
    }

    @Then("^user should see the \"([^\"]*)\" Pin your city search result$")
    public void userShouldSeeThePinYourCitySearchResult(String city) throws Throwable {
       log("Verify that in search result "+city+ " is appearing or not");
       Assert.assertTrue(weatherPage.isCityAvailableInSearchList(city,1),"Verification failed , "+city+" city is not appearing in Pin your city search result");
       log("Verification pass successfully , "+city+" city is appearing in Pin your city search result");
    }

    @When("^user select \"([^\"]*)\" from Pin your city search result$")
    public void userSelectFromPinYourCitySearchResult(String city) throws InterruptedException {
        log("Select "+city+" city from Pin your city search result ");
        weatherPage.selectCityFromSearchResult(city,1);
        log("Selected "+city+" city from search result");
    }

    @Then("^user should see the \"([^\"]*)\" city in map$")
    public void userShouldSeeTheCityInMap(String city) throws Throwable {
        log("Verify that in map "+city+ " city is appearing or not");
        Assert.assertTrue(weatherPage.isCityAppearsOnMap(city,1),"Verification failed , "+city+" city is not appearing in the map");
        log("Verification pass successfully , "+city+" city is appearing in the map");
    }

    @When("^user click on the \"([^\"]*)\" city in map$")
    public void userClickOnTheCityInMap(String city) throws InterruptedException {
        log("Select "+city+" city from map");
        weatherPage.clickOnTheCity(city,1);
        log("Selected "+city+" city from map");
    }

    @Then("^user should see the popup of \"([^\"]*)\" detail in the map$")
    public void userShouldSeeThePopupOfDetailInTheMap(String city) throws InterruptedException {
        log("Verify that in map ,popup for weather detail of "+city+ " city is appearing or not");
        Assert.assertTrue(weatherPage.isCityWeatherDataAppearsAfterClickingOnTheCity(city,20),"Verification failed , in map , popup for weather detail of "+city+ " city is not appearing");
        log("Verification Pass successfully , in map , popup for weather detail of "+city+ " city is appearing");
    }
}
