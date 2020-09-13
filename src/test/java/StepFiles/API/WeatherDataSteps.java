package StepFiles.API;

import ActionClasses.API.CityWeatherData;
import StepFiles.Logging;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;

public class WeatherDataSteps extends Logging {

    TestContext testContext;
    CityWeatherData cityWeatherData;

    public WeatherDataSteps(TestContext context) {
        testContext = context;
        cityWeatherData = testContext.getPageObjectMangerAPI().getCityWeatherData();
    }

    @When("^user get the data for endpoint \"([^\"]*)\" with pathParam$")
    public void userGetTheDataForEndpointWithPathParam(String endPoint, DataTable credentials)  {
        cityWeatherData.getWeatherInformation(endPoint,credentials.asMap(String.class, String.class));
    }

    @When("^user store the data for the city \"([^\"]*)\" from api$")
    public void userStoreTheDataForTheCityFromApi(String arg0) throws Throwable {
        cityWeatherData.storeWeatherDataForCity();
    }

}
