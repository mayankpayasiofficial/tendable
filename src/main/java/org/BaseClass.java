package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import dataprovider.ConfigDataProvider;

public class BaseClass {

	public static WebDriver driver;

	public static String tendable_url;



	public static void launchApplication() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayush\\Desktop\\project\\testsuite_tendable\\src\\test\\resources\\browser_drivers\\geckodriver.exe");
		String browserName = ConfigDataProvider.getBrowser();
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
				System.out.println("Chrome Browser is launched");
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				System.out.println("Firefox Browser is launched");
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				System.out.println("Edge Browser is launched");
			}
		} catch (Exception ex) {
			System.out.println("Exception occurred while launching browser. " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public static void launchApplicationTendable() {
		try {
			tendable_url = ConfigDataProvider.getTendableURL();
			driver.manage().window().maximize();
			driver.get(tendable_url);
			System.out.println("Tendable Application is launched and url is: " + tendable_url);
			System.out.println("Tendable Application is up and running");
		}
		catch (Exception E){}

	}
}
