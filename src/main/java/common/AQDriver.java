package common;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AQDriver {
	private static WebDriver driver = null;

	// Definite wait period
	public static void waitFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	// Method for implicit wait
	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// Explicit wait function
	public static void explicitWait(By by, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// Wait till the page is loaded
	public static void waitTillPageLoaded(int sec) {
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}

	// Method for setting capabilities and launching the app on the
	// device/emulator
	public static WebDriver setup(String platform) throws MalformedURLException {

		if (platform.equals(AQConstants.PLATFORM_FIREFOX)) {
			System.setProperty("webdriver.gecko.driver", "src/main/java/drivers/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);

		} else if (platform.equals(AQConstants.PLATFORM_CHROME)) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver");
			driver = new ChromeDriver();
			AQDriver.getCurrentDriver().manage().window().setPosition(new Point(0, 0));
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Dimension currentDimension = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
			AQDriver.getCurrentDriver().manage().window().setSize(currentDimension);
		}
		
		waitFor(AQConstants.SHORT_WAIT_TIME);
		return driver;
	}

	// Method to quit
	public static void quit() {
		driver.quit();
	}

	// Method to get current driver
	public static WebDriver getCurrentDriver() {
		return driver;
	}
	
}
