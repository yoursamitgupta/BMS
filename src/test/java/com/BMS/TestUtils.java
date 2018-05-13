package com.BMS;

import java.awt.List;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BMS.pageobjects.BookingPage;

public class TestUtils {

	public static WebDriver dr;
	public static String filePath = new File("").getAbsolutePath();

	public static WebDriver getDriver() {

		if (ProjectConfiguration.browserType.equalsIgnoreCase("CHROME")) {

			String osName = System.getProperty("os.name");
			if (osName.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver", filePath + "/BrowsersDriver/chromedriver");
			} else {
				System.setProperty("webdriver.chrome.driver", filePath + "\\BrowsersDriver\\chromedriver.exe");
			}
			DesiredCapabilities cap = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("test-type");
			options.addArguments("enable-strict-powerful-feature-restrictions");
			options.addArguments("disable-geolocation");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cap);
			dr = new ChromeDriver(options);
		}

		else if (ProjectConfiguration.browserType.equalsIgnoreCase("FIREFOX")) {
			String osName = System.getProperty("os.name");
			if (osName.contains("Mac")) {
				System.setProperty("webdriver.gecko.driver", filePath + "/BrowsersDriver/geckodriver");
			} else {
				System.setProperty("webdriver.gecko.driver", filePath + "\\BrowsersDriver\\geckodriver.exe");
			}
			FirefoxProfile geoDisabled = new FirefoxProfile();
			geoDisabled.setPreference("geo.enabled", false);
			geoDisabled.setPreference("geo.provider.use_corelocation", false);
			geoDisabled.setPreference("geo.prompt.testing", false);
			geoDisabled.setPreference("geo.prompt.testing.allow", false);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
			FirefoxOptions op = new FirefoxOptions();
			op.merge(capabilities);
			dr = new FirefoxDriver(op);
		}
		return dr;

	}

	public void verifyPage(String page) {
		String Actual = "";
		String expected = "";
		WebDriverWait wait = new WebDriverWait(dr, 30);

		switch (page) {

		case "HomePage":
			wait.until(ExpectedConditions.urlToBe("https://in.bookmyshow.com/bengaluru"));
			Actual = dr.getTitle().trim();
			expected = "Movie Tickets, Plays, Sports, Events & Cinemas near Bangalore - BookMyShow";
			Assert.assertEquals(Actual, expected);
			break;
		case "MoviePage":
			wait.until(ExpectedConditions.urlToBe("https://in.bookmyshow.com/bengaluru/movies"));
			Actual = dr.getTitle().trim();
			expected = "Bengaluru Movie Tickets Online Booking & Showtimes near you - BookMyShow";
			Assert.assertEquals(Actual, expected);
			break;

		}

	}

	public void clickOnTab(String tabName) {
		WebDriverWait wait = new WebDriverWait(dr, 30);
		switch (tabName) {

		case "Movie":
			wait.until(ExpectedConditions.elementToBeClickable(BookingPage.movieTab(dr)));
			BookingPage.movieTab(dr).click();
			break;
		case "Events":

			BookingPage.eventsTab(dr).click();
			break;
		case "Plays":
			BookingPage.playsTab(dr).click();
			break;
		case "Sports":
			BookingPage.sportsTab(dr).click();
			break;
		case "ipl":
			BookingPage.iplTab(dr).click();
			break;

		}

	}

	/*
	 * public void selectMovie(String MovieName){
	 * 
	 * WebDriverWait wait = new WebDriverWait(dr, 30);
	 * 
	 * BookingPage.loadMore(dr).click();
	 * 
	 * List<WebElement> movie=
	 * dr.findElements(By.xpath("//div[@data-selector='movies']"));
	 * 
	 * List<WebElement> button=
	 * dr.findElements(By.xpath("//div[@class='book-button']"));
	 * 
	 * int n =1; int j=1; for (WebElement el: movie){
	 * 
	 * if (el.getAttribute("data-search-filter").contains(MovieName)){
	 * 
	 * for (WebElement b: button){
	 * 
	 * if (j==n){ // wait.until(ExpectedConditions.el) b.click(); }
	 * 
	 * 
	 * }
	 * 
	 * } n=n+1;
	 * 
	 * }
	 * 
	 * }
	 */

	public void selectMovie() {
		JavascriptExecutor jse = (JavascriptExecutor)dr;
		jse.executeScript("scroll(0, 800);");
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BookingPage.bookNowButton(dr)));
	BookingPage.bookNowButton(dr).click();
		
	}

	public void selectDate() {
		String actual = dr.findElement(By.xpath("/html/body/div[1]/section/div[1]/div[2]/div[1]/div/h1/div[1]/a"))
				.getText().trim();
		String expected = "Bharat Ane Nenu";
		Assert.assertEquals(actual, expected);
		
		System.out.println("gggggggggggggggggg");
		
		BookingPage.date(dr).click();
		
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='venuelist']/li[1]/div[2]/div[2]")));
		dr.findElement(By.xpath("//*[@id='venuelist']/li[1]/div[2]/div[2]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btnPopupAccept']")));
		dr.findElement(By.xpath("//*[@id='btnPopupAccept']")).click();
		
		
	}
	
	public void selectSeat(){
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pop_1']")));
		dr.findElement(By.xpath("//*[@id='pop_1']")).click();
		
		dr.findElement(By.xpath("//*[@id='proceed-Qty']")).click();
		
	}
	
	public void checkSeat(){
		
		//List<WebElement> row = dr.findElements(By.xpath("//*[@id='layout']/table/tbody/tr/td[2]"));
		//List<WebElement> column = dr.findElements(By.xpath("//*[@id='layout']/table/tbody/tr/td[2]"));
		
		
		
		if (dr.findElement(By.xpath("//*[@id='A_5_01']/a")).getAttribute("class").equalsIgnoreCase("_available")){
			
			System.out.println("available");
			dr.findElement(By.xpath("//*[@id='A_5_01']/a")).click();
		}else{
			System.out.println("Not avaialable or Booked");
		}
		
	}

}
