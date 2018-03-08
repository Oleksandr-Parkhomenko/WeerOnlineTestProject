import java.net.MalformedURLException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AppMainScreenPage;
import pageObjects.OnderdelenWijzigenPage;
import pageObjects.StartPage;
import pageObjects.ZoekEenPlaatsPage;

public class Tests extends Basic{

	private static AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() {
		try {
			driver = Capabilities();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void searchLocation() {
		 Boolean result;
		 String cityName = "Hilversum";
		 
		 StartPage startP = new StartPage(driver);
		 ZoekEenPlaatsPage searchF = new ZoekEenPlaatsPage(driver);
		 
		 startP.ZoekEenPlaatsButton.click();
		 searchF.SearchField.sendKeys("Hilversum");
	     searchF.SelectSearchHilv.click();
	     
	     result = checkResult("//android.widget.TextView[@text='Hilversum']", cityName);
	     Assert.assertEquals( cityName + " was not found", result, true);
	}
	
	
	@Test 
	public void favoriteLocation() {
		 Boolean result;
		 String cityName = "Amsterdam";
		 
		 ZoekEenPlaatsPage searchF = new ZoekEenPlaatsPage(driver);
		 AppMainScreenPage mainScreen = new AppMainScreenPage(driver);
		 
		 mainScreen.CityInput.click();
		 searchF.SearchField.sendKeys(cityName);
	     searchF.SelectSearchAmst.click();
		 mainScreen.StarButton.click();
	     mainScreen.HamburgerButton.click();
	     	     
	     result = checkResult("//android.widget.TextView[@text='Amsterdam']", cityName);
	     Assert.assertEquals( cityName + " was not selected as a favorite location", result, true);
	}
	
	@Test
	public void selectUursAndDaagseWidgets() {
		 String widget48uur = "48-uurs verwachting";
		 String widget14daagse = "14-daagse verwachting";
		 Boolean result;
		 
		 ZoekEenPlaatsPage searchF = new ZoekEenPlaatsPage(driver);
		 AppMainScreenPage mainScreen = new AppMainScreenPage(driver);
		 OnderdelenWijzigenPage onderdelenWijzigenP = new OnderdelenWijzigenPage(driver);
		 
		 searchF.SelectSearchAmst.click();
	     mainScreen.HamburgerButton.click();
	     driver.findElementByAndroidUIAutomator("text(\"Onderdelen wijzigen\")").click();
	     
	     onderdelenWijzigenP.Weeradvies.click();
	     onderdelenWijzigenP.HetKomendeUur.click();
	     onderdelenWijzigenP.Neerslagradar.click();
	     onderdelenWijzigenP.Neerslaggrafiek.click();
	     onderdelenWijzigenP.BeverWeercijfer.click();
	     onderdelenWijzigenP.Activiteiten.click();
	     onderdelenWijzigenP.Weerbericht.click();
	     onderdelenWijzigenP.Wintersport.click();
	     
	     mainScreen.BackButton.click();
	     
	     result = checkResult("//android.widget.TextView[@text='48-uurs verwachting']", widget48uur);
	     Assert.assertEquals(widget48uur + " widget is missing.", result, true);
	    
	     result = checkResult("//android.widget.TextView[@text='14-daagse verwachting']", widget14daagse);
	     Assert.assertEquals(widget14daagse + " widget is missing.", result, true);
	}
	
	@Test
	public void showForecastForFortyEightHours() {
		 Boolean result;
		 String widget48uur = "48-uurs verwachting";
	     
	     driver.findElementById("com.xs2theworld.weeronline:id/toolbar_city_name").isDisplayed();
	     driver.findElementById("com.xs2theworld.weeronline:id/card_48_hours").click();
	     
	     result = checkResult("//android.widget.TextView[@text='48-uurs verwachting']", widget48uur);
	     Assert.assertEquals(widget48uur + " widget is missing.", result, true);
	}  
	
	@Test
	public void uncheckWidgets() {
		 Boolean result;
		 String text = "Onderdelen wijzigen";
		 
		 AppMainScreenPage mainScreen = new AppMainScreenPage(driver);
		 OnderdelenWijzigenPage onderdelenWijzigenP = new OnderdelenWijzigenPage(driver);
		 
		 mainScreen.BackButton.click();
		 mainScreen.HamburgerButton.click();
	     driver.findElementByAndroidUIAutomator("text(\"Onderdelen wijzigen\")").click();
	     
	     onderdelenWijzigenP.UursVerwachting.click();
	     onderdelenWijzigenP.DaagseVerwachting.click();
	     
	     mainScreen.BackButton.click();
	     
	     result = checkResult("//android.widget.Button[@text='Onderdelen wijzigen']", text);
	     Assert.assertEquals("Not all widgets hidden", result, true);
	} 
	
	@AfterTest
	public void signOut()
	{
		tearDown();
	}
	
}
