package com.makemytrip.utils;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.makemytrip.base.MakeMyTripBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends MakeMyTripBase{
	
	static WebDriver driver;

	@Before
	public void launchBrowser() throws MalformedURLException {
		System.out.println("********* Initialize driver *******");
		driver=driverInitialization();
		System.out.println("********* Initialize driver Successfullly *******");

	}

	@After
	public void AfterSteps() {
//		driver.quit();
	}

}
