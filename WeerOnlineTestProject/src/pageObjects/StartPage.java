package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StartPage {

	public StartPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/search_button")
	public WebElement ZoekEenPlaatsButton;
	
}
