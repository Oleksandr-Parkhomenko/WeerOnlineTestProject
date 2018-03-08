import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Basic {
	
	private static AndroidDriver<AndroidElement> driver;
	public static String emulatorName = "Nexus_5_Emulator";
	public static String appName = "com.xs2theworld.weeronline_2018021902.apk";
	public static String appPackage = "com.xs2theworld.weeronline";
	public static String appActivity = "com.xs2theworld.weeronline.launch.StartupActivity";

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
	
		 File appDir = new File("src");
	     File app = new File(appDir, appName);
	     
	     DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
	     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	     capabilities.setCapability("appPackage", appPackage);
	     capabilities.setCapability("appActivity", appActivity);
	     
	     driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     return driver;
	}
	
	public static Boolean checkResult(String element, String text) {
		String result = driver.findElementByXPath(element).getText();
	    if(result.equals(text)) 
	    	return true;
	    else
	    	return false;
	}
	
	
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
		}

	}

}
