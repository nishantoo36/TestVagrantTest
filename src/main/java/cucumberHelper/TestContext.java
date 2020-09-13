package cucumberHelper;
import manager.API.PageObjectMangerAPI;
import manager.UI.DriverFactor;
import manager.UI.PageObjectMangerUI;

public class TestContext {
	private PageObjectMangerUI pageObjectMangerUI;
	private PageObjectMangerAPI pageObjectMangerAPI;

	private DriverFactor driverFactory;
	public ScenarioContext scenarioContext;
	public TestContext(){
		driverFactory = new DriverFactor();
		pageObjectMangerUI = new PageObjectMangerUI(driverFactory.getDriver());
		pageObjectMangerAPI = new PageObjectMangerAPI();
		scenarioContext = new ScenarioContext();
	}

	public DriverFactor getDriverFactory() {
		return driverFactory;
	}

	public PageObjectMangerUI getPageObjectMangerUI() {
		return pageObjectMangerUI;
	}

	public PageObjectMangerAPI getPageObjectMangerAPI() {
		return pageObjectMangerAPI;
	}

	public ScenarioContext getScenarioContext() {
		 return scenarioContext;
		 }
}
