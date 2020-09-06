package StepFiles;

import ActionClasses.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;

public class LoginPageSteps extends Logging {
    TestContext testContext;
    LoginPage loginPage;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManger().getLoginPage();
    }

    @Then("^user should see the \"([^\"]*)\"$")
    public void userShouldSeeThe(String pageTitle) {
        log("Verify that user is on " + pageTitle + " page");
        Assert.assertTrue(loginPage.isUserOnLoginPage(pageTitle), "Verification failed, user is not on the " + pageTitle);
        log("Verification pass successfully , user is on " + pageTitle + " page");
    }

    @When("^user enter username as \"([^\"]*)\"$")
    public void userEnterUsernameAs(String username) {
        log("Enter username as " + username);
        loginPage.enterUserName(username);
        log("Entered username as " + username);
    }

    @When("^user enter password as \"([^\"]*)\"$")
    public void userEnterPasswordAs(String password) {
        log("Enter username as " + password);
        loginPage.enterPassword(password);
        log("Entered username as " + password);
    }

    @When("^user click on login button$")
    public void userClickOnLoginButton() {
        log("Click on login button");
        loginPage.clickOnLogin();
        log("Clicked on login button");
    }

    @Then("^user get error message as \"([^\"]*)\"$")
    public void userGetErrorMessageAs(String message) {
        log("Verify the error message as " + message);
        Assert.assertEquals(message, loginPage.getErrorMessage(), "Verification failed, ' " + message + " ' error message is not appearing ");
        log("Verification pass successfully , error message is appearing as ' " + message + " ' ");
    }
}
