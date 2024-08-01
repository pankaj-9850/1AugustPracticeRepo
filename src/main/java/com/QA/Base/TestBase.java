package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties property;
	public static WebDriver driver;
	public static ChromeOptions option;
	public TestBase() {
		
		String path = System.getProperty("user.dir")+"src\\main\\java\\properties\\config.properties";
		
		try {
			FileInputStream file = new FileInputStream(path);
			property = new Properties();
			property.load(file);
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void initialiseBrowserMethod() {
		
		String browsername = System.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			option = new ChromeOptions();
			driver = new ChromeDriver();
		}
		else if(browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(System.getProperty("OpenMRSurl"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	}
}
