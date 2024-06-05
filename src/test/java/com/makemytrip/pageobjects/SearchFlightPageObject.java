package com.makemytrip.pageobjects;

import org.openqa.selenium.By;
import com.makemytrip.base.MakeMyTripBase;
import com.makemytrip.utils.CommonMethod;

public class SearchFlightPageObject extends MakeMyTripBase {

	By adsPopupCloseIcon = By
			.xpath("//div[@id='webklipper-publisher-widget-container-notification-container']/a[@class='close']");
	By LoginPopupCloseIcon = By.xpath("//span[@data-cy='closeModal']");
	By MakeMyTripLogo = By.xpath("//img[@alt='Make My Trip']");
	By FromInputField = By.xpath("//input[@id='fromCity']");
	By ToInputField = By.xpath("//input[@data-cy='toCity']");
	By ToAutoSuggestionInput = By.xpath("(//div[@id='react-autowhatever-1']/../../../..//li[@role='option'])[1]");

	By SearchButton = By.xpath("//a[text()='Search']");

	public void verify_HomePage() throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().frame("notification-frame-173054a2c");
		CommonMethod.waitForElementVisibility(adsPopupCloseIcon, 10);
		driver.findElement(adsPopupCloseIcon).click();
		driver.switchTo().defaultContent();
		CommonMethod.waitForElementVisibility(LoginPopupCloseIcon, 10);
		driver.findElement(LoginPopupCloseIcon).click();
		CommonMethod.waitForElementVisibility(MakeMyTripLogo, 10);

	}

	public void enter_Origin_And_Destination_Input(String org, String dest) throws InterruptedException {
		CommonMethod.waitForElementVisibility(FromInputField, 10);
		driver.findElement(FromInputField).sendKeys(org);
		// driver.findElement(FromInputField).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(ToInputField).click();
		CommonMethod.waitForElementVisibility(ToInputField, 10);
		driver.findElement(ToInputField).sendKeys(dest);
		Thread.sleep(2000);
		driver.findElement(ToAutoSuggestionInput).click();

	}

	public void select_DepartureDate() throws InterruptedException {

		CommonMethod.selectCuurentDate();
		
	}

	public void click_On_Search() throws InterruptedException {

		driver.findElement(SearchButton).click();
	}
}
