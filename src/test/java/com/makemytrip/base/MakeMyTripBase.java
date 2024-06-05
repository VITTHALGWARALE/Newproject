package com.makemytrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MakeMyTripBase {

	public static WebDriver driver;
	public static Properties prop;
	public String getBrowserName;
	public String URL;

	public MakeMyTripBase() {

		try {
			prop = new Properties();
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			String propFilePath=System.getProperty("user.dir") + "/src/test/resource/properties/config.properties";
			FileInputStream fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}

	public WebDriver driverInitialization() throws MalformedURLException {

		getBrowserName = prop.getProperty("browserName");
		URL = prop.getProperty("prodUrl");

		if(getBrowserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			driver = new ChromeDriver(options);
		}
		else if(getBrowserName.equalsIgnoreCase("Egde")) {
			driver = new EdgeDriver();
		}
		else if(getBrowserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
