package StepFiles;

import ActionClasses.Comparator;
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


    @Then("^compare the temperature data for UI and API in \"([^\"]*)\" and validate that both should be nealy same$")
    public void compareTemperature(String tempType) throws Exception {
        log("Compare the data");
        Assert.assertTrue(comparator.isTempCorrect(tempType));
        log("Verification pass successfully");
    }
}
