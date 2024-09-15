package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.demo.qa.factory.DriverFactory;
import com.demo.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DemoApplicationHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 2)
	public void getBrowser() {
		String browser = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browser);
	}

	@After(order = 2)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll("", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "/image/png", screenShotName);

		}
	}

}
