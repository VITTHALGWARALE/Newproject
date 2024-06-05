package com.makemytrip.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.base.MakeMyTripBase;

public class CommonMethod extends MakeMyTripBase{
	
	public static WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
		
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutInSeconds) );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public static WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	
	public static void clickUntilInvisible(By locator, int timeoutInSeconds) {
      
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        // Perform a loop to click until the element becomes invisible
        while (true) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                element.click();
            } catch (Exception e) {
                // Element is not clickable or has become invisible
                break;
            }
        }
	}
	public static String removeSpecialCharacters(String input) {
        // Define a regular expression to match special characters
        String regex = "[^a-zA-Z0-9\\s]";

        // Use the regular expression to replace special characters with an empty string
        return input.replaceAll(regex, "");
    }
	public static String extractNumeric(String input) {
        // Define a regular expression pattern to match numeric values
        Pattern pattern = Pattern.compile("\\d+");

        // Create a matcher object and apply the pattern to the input string
        Matcher matcher = pattern.matcher(input);

        // Check if a numeric value is found
        if (matcher.find()) {
            // Extract the numeric value
            return matcher.group();
        } else {
            // Handle the case where no numeric value is found
            return "No numeric value found";
        }
    }
	
	public static void selectCuurentDate() throws InterruptedException {
		// Locate the departure date input field and click on it
//        WebElement departureDateInput = driver.findElement(By.xpath("//input[@id='departure']"));
//        Thread.sleep(3000);
//        departureDateInput.click();

        // Get the current date
//		 LocalDate currentDate = LocalDate.now();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
//	        String currentDay = formatter.format(currentDate);
//        System.out.println("Cuurent Date : "+currentDay);
        
        // Locate the element corresponding to the current date in the datepicker and click on it
        WebElement currentDateElement = driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']"));
        currentDateElement.click();
	}
	
	public static void clickElementWithJavaScript(By locator) {
		WebElement element= driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}
