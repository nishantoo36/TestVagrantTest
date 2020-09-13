package StepFiles.API;

import ActionClasses.API.CityWeatherData;
import ActionClasses.API.CommonApiMethods;
import StepFiles.Logging;
import cucumber.api.java.en.Then;
import cucumberHelper.TestContext;

public class CommonSteps extends Logging {
    TestContext testContext;
    CommonApiMethods commonApiMethods;

    public CommonSteps(TestContext context) {
        testContext = context;
        commonApiMethods = testContext.getPageObjectMangerAPI().getCommonApiMethods();
    }

    @Then("^validate the status code should be \"([^\"]*)\"$")
    public void validateTheStatusCodeShouldBe(int statusCode) {
        commonApiMethods.getStatusCode();
    }
}
