


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import java.net.MalformedURLException;
import java.net.URL;

public class StartAppTest {


	//  public TestWatcher watcher = Factory.createWatcher();

	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	private static EnhancedIOSDriver<WebElement> driver;
	private static  EnhancedIOSDriver<WebElement> startApp() throws MalformedURLException  {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		/*capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");																																														
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "03157df33ccbbd36");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/Mobile/Desktop/Newjersy.apk");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);*/
	//	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		//	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability("platformVersion", "10.3.3");
		capabilities.setCapability("deviceName", "Iphone6 Black New");
		capabilities.setCapability("udid", "d1c25a34a020a1e004f345be793a3ee5c459250c");
		//desiredCapabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("app", "/Users/Mobile/Desktop/App Center/nj.ipa");

		
		URL url = new URL("http://localhost:4723/wd/hub");
		//driver = (EnhancedAndroidDriver) new AndroidDriver(url, capabilities);


		return Factory.createIOSDriver(url, capabilities);
	}


	@Test
	public void canStartAppInTest() throws Exception {
		driver = startApp();
		
		Thread.sleep(5000);
		//		WebDriverWait wait=new WebDriverWait(driver, 70);
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("slideNavButton")));
		MobileElement el11 = (MobileElement) driver.findElementById("Allow");
		el11.click();
		Thread.sleep(2000);
		MobileElement el1 = (MobileElement) driver.findElementById("slideNavButton");
		el1.click();
	        driver.label("Menu button is tapping");
		 Thread.sleep(2000);
	     MobileElement el2 = (MobileElement) driver.findElementById("winningNumberSlide");
	     el2.click();
	     Thread.sleep(2000);
	     MobileElement el3 = (MobileElement) driver.findElementById("headerBackButton");
	     el3.click();
		driver.label("Menu button is tapping again");
	     Thread.sleep(7000);
	}

	@After
	public void after() throws Exception {
		if (driver != null) {
			driver.label("Stopping App");
			driver.quit();
		}
	}
}
