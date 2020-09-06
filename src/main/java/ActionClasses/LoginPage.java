package ActionClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.SeleniumUtility;

public class LoginPage extends SeleniumUtility {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "google")
    WebElement loginWithGmailButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath="//div[@id='error']/p")
    WebElement errorMessage;

    @FindBy(id = "btnlogin")
    WebElement loginBtn;

    public boolean isUserOnLoginPage(String pageTitle) {
        return pageTitle.equals(getPageTitle());
    }

    public void enterUserName(String userName) {
        enterValue(emailField, userName, 5);
    }

    public void enterPassword(String password) {
        enterValue(passwordField, password, 5);
    }

    public void clickOnLogin() {
       loginBtn.submit();
    }
    public String getErrorMessage(){
        return getText(errorMessage,5);
    }


}

