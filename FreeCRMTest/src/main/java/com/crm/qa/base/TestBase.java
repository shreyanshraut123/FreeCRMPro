package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	// Global variable
	public static WebDriver driver;
	public static Properties prop;

	// Properties read
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\java\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	//The global variable initialized
	public static void initialization() {
		 String browserName= prop.getProperty("browser");
		 
		 if(browserName.equals("chrome")) {
			driver =new ChromeDriver();
		 }else if(browserName.equals("ED")) {
			 driver = new EdgeDriver();
		 }
		 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(com.crm.qa.util.TestUtil.PAGE_LOAD_TIMEOUT ));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(com.crm.qa.util.TestUtil.IMPLICIT_WAIT));
		 
		 driver.get(prop.getProperty("url"));
	}

}
