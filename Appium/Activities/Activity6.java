package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "<device name>");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 5);
	}

	@Test
	public void imageScrollTest() throws InterruptedException {
		driver.get("https://www.training-support.net/selenium/lazy-loading");
		Thread.sleep(5000);

		// wait for page to load
		MobileElement pageTitle = driver.findElementByXPath("	\r\n"
				+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[2]");

		System.out.println(pageTitle.getText());

		// Count the number of images shown on the screen
		List<MobileElement> numberOfImages = driver
				.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		int noIfImgs = numberOfImages.size();
		System.out.println("Number of image shown currently: " + numberOfImages.size());

		// Assertion before scrolling
		Assert.assertEquals(noIfImgs, 2);

		// Scroll to Helen's post
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"helen\"))"));

		// Find the number of images shown after scrolling
		numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		System.out.println("Number of image shown currently: " + numberOfImages.size());

		// Assertion after scrolling
		Assert.assertEquals(numberOfImages.size(), 20);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}