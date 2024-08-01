package com.QA.Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Base.TestBase;

public class Utils extends TestBase{

	public static void simpleClickMethod(WebElement element) {
		element.click();
	}
	public static void senkeysMethod(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void waitSingleEle(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitMultipleEle(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public static void EleTobeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
