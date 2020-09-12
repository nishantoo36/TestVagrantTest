package StepFiles.UI;

import ActionClasses.UI.HomePage;
import StepFiles.Logging;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;

public class HomePageSteps extends Logging {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectMangerUI().getLoginPage();
    }

    @Then("^user should see the home page title \"([^\"]*)\"$")
    public void userShouldSeeThe(String pageTitle) {
        log("Verify that user is on " + pageTitle + " page");
        Assert.assertTrue(homePage.isUserOnHomePage(pageTitle,10), "Verification failed, user is not on the " + pageTitle);
        log("Verification pass successfully , user is on " + pageTitle + " page");
    }

    @When("^user click on \"([^\"]*)\" option from header menu$")
    public void userClickOnOptionFromHeaderMenu(String menu) throws InterruptedException {
       log("Click on "+menu+" from headers menu");
       homePage.clickOnMenu(menu.toUpperCase(),5);
       log("Clicked on "+menu+" menu option");
    }

}
