package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OnderdelenWijzigenPage {

	public OnderdelenWijzigenPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	@AndroidFindBy(uiAutomator="text(\"Weeradvies\")")
	public WebElement Weeradvies;
	@AndroidFindBy(uiAutomator="text(\"Het komende uur\")")
	public WebElement HetKomendeUur;
	@AndroidFindBy(uiAutomator="text(\"48-uurs verwachting\")")
	public WebElement UursVerwachting;
	@AndroidFindBy(uiAutomator="text(\"Neerslagradar\")")
	public WebElement Neerslagradar;
	@AndroidFindBy(uiAutomator="text(\"Neerslaggrafiek\")")
	public WebElement Neerslaggrafiek;
	@AndroidFindBy(uiAutomator="text(\"14-daagse verwachting\")")
	public WebElement DaagseVerwachting;
	@AndroidFindBy(uiAutomator="text(\"Bever weercijfer\")")
	public WebElement BeverWeercijfer;
	@AndroidFindBy(uiAutomator="text(\"Activiteiten\")")
	public WebElement Activiteiten;
	@AndroidFindBy(uiAutomator="text(\"Weerbericht\")")
	public WebElement Weerbericht;
	@AndroidFindBy(uiAutomator="text(\"Wintersport\")")
	public WebElement Wintersport;
	
}
