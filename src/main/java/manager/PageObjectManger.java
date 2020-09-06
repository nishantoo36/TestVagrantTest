package manager;


import ActionClasses.CommonUIActions;
import ActionClasses.LoginPage;
import org.openqa.selenium.WebDriver;
public class PageObjectManger {

	public WebDriver driver;
	public CommonUIActions commonUIActions;
	public LoginPage loginPage;


	public PageObjectManger(WebDriver driver) {
		this.driver = driver;
	}

	public CommonUIActions getCommonActionsScreen() {
		return (commonUIActions == null) ? commonUIActions = new CommonUIActions(driver) : commonUIActions;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	

}


