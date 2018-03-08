package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppMainScreenPage {

	public AppMainScreenPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/toolbar_star")
	public WebElement StarButton;
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/toolbar_menu")
	public WebElement HamburgerButton;
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/toolbar_city_input")
	public WebElement CityInput;
	@AndroidFindBy(id="com.xs2theworld.weeronline:id/toolbar_menu")
	public WebElement BackButton;
	
}
