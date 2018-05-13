package com.BMS.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {
	public static WebElement element;

	public static WebElement movieTab(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[1]"));

	}

	public static WebElement eventsTab(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[2]"));

	}

	public static WebElement playsTab(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[3]"));

	}

	public static WebElement sportsTab(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[4]"));

	}

	public static WebElement iplTab(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@class='inner-nav left-nav']/ul/li[5]"));

	}
	
	/*public static WebElement loadMore(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@id='now-showing']/section[1]/div/div[2]/div[3]/button"));

	}*/
	
	public static WebElement bookNowButton(WebDriver dr) {

		return dr.findElement(By.xpath("//div[@data-selector='movies'][2]/div/div/div[5]"));

	}
	public static WebElement date(WebDriver dr) {

		return dr.findElement(By.xpath("//*[@id='showDates']/li[5]"));

	}
	
	

}
