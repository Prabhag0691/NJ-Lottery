


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

	private static EnhancedAndroidDriver<WebElement> driver;
	private static  EnhancedAndroidDriver<WebElement> startApp() throws MalformedURLException  {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");																																														
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "03157df33ccbbd36");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/Mobile/Desktop/Newjersy.apk");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
	//	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		//	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);

		URL url = new URL("http://localhost:4723/wd/hub");
		//driver = (EnhancedAndroidDriver) new AndroidDriver(url, capabilities);


		return Factory.createAndroidDriver(url, capabilities);
	}


	@Test
	public void canStartAppInTest() throws Exception {
		driver = startApp();
		Thread.sleep(5000);
		//		WebDriverWait wait=new WebDriverWait(driver, 70);
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("slideNavButton")));
		MobileElement el1 = (MobileElement) driver.findElementById("slideNavButton");
		el1.click();
		//Thread.sleep(5000);
		// MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View");
		// el2.click();
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
