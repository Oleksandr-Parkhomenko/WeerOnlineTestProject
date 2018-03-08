package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ZoekEenPlaatsPage {

	public ZoekEenPlaatsPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/edit_text")
	public WebElement SearchField;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Amsterdam']")
	public WebElement SelectSearchAmst;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hilversum']")
	public WebElement SelectSearchHilv;
		
}
