package manager.UI;


import ActionClasses.UI.CommonUIActions;
import ActionClasses.UI.HomePage;
import ActionClasses.UI.WeatherPage;
import org.openqa.selenium.WebDriver;
public class PageObjectMangerUI {

	public WebDriver driver;
	public CommonUIActions commonUIActions;
	public HomePage homePage;
	public WeatherPage weatherPage;


	public PageObjectMangerUI(WebDriver driver) {
		this.driver = driver;
	}

	public CommonUIActions getCommonActionsScreen() {
		return (commonUIActions == null) ? commonUIActions = new CommonUIActions(driver) : commonUIActions;
	}

	public HomePage getLoginPage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public WeatherPage getWeatherPage() {
		return (weatherPage == null) ? weatherPage = new WeatherPage(driver) : weatherPage;
	}
}


