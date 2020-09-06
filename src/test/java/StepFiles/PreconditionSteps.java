package StepFiles;
import ActionClasses.CommonUIActions;
import cucumber.api.java.en.Given;
import cucumberHelper.TestContext;

public class PreconditionSteps extends Logging {

    TestContext testContext;
    CommonUIActions commonUIActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonUIActions = testContext.getPageObjectManger().getCommonActionsScreen();
    }

    @Given("User should be on Login Page")
    public void userShouldBeOnLoginPage() {
        commonUIActions.openMainURL();
        commonUIActions.setAcceptCookies();
        log("User is on Login page");
    }
}
