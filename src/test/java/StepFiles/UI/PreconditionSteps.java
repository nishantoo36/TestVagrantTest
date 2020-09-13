package StepFiles.UI;
import ActionClasses.UI.CommonUIActions;
import StepFiles.Logging;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;

import java.util.concurrent.TimeoutException;

public class PreconditionSteps extends Logging {

    TestContext testContext;
    CommonUIActions commonUIActions;

    public PreconditionSteps(TestContext context) {
        testContext = context;
        commonUIActions = testContext.getPageObjectMangerUI().getCommonActionsScreen();
    }

    @When("open Homepage")
    public void userShouldBeOnLoginPage() {
        try {
            commonUIActions.openMainURL(10);
            commonUIActions.acceptAlert(2);
        }catch (Exception e){
            if(!commonUIActions.isAlertAppear(2)){
                log("No alert appear so perform next step");
            }
        }
        log("User is on Login page");
    }
}
