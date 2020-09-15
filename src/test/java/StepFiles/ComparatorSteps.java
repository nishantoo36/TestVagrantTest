package StepFiles;

import ActionClasses.Comparator;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumberHelper.TestContext;
import org.testng.Assert;

public class ComparatorSteps extends Logging {
    TestContext testContext;
    Comparator comparator;

    public ComparatorSteps(TestContext context) {
        testContext = context;
        comparator = testContext.getPageObjectMangerAPI().getComparator();
    }


    @Then("^compare the temperature data for UI and API in \"([^\"]*)\" and validate that both should be nealy same with variance less than \"([^\"]*)\"$")
    public void compareTemperature(String tempType,double expectedVariance) {
        log("Compare the city temperature data");
        Assert.assertTrue(comparator.isTempCorrect(tempType,expectedVariance),"Verification failed, the variance for city temperature data from Api and UI is more than expected which is "+"for UI = "+ comparator.UIData +" for API = "+comparator.APIData);
        log("Verification pass successfully, the variance for city temperature data is less than expected from Api and UI "+comparator.variance);
    }

    @Then("^compare the humidity data for UI and API and validate that both should be nealy same with variance less than \"([^\"]*)\"$")
    public void compareTheHumidityDataForUIAndAPIAndValidateThatBothShouldBeNealySame(double expectedVariance) {
        log("Compare the humidity temperature data");
        Assert.assertTrue(comparator.isHumidity(expectedVariance),"Verification failed,the variance for city humidity data is more than expected for API and UI which is "+"for UI = "+ comparator.UIData +" for API = "+comparator.APIData);
        log("Verification pass successfully,the variance for city humidity data is less than expected for API and UI which is "+comparator.variance);
    }
}
