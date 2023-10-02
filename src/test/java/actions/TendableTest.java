package actions;
import java.time.Duration;
import static org.BaseClass.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utils.Common.*;

public class TendableTest {

	public static WebElement element;



	public static void homePage() {

		driver.navigate().refresh();
	}

	public static void confirmMenuAccessibility(String menuName) {
		WebElement menu = driver.findElement(By.linkText(menuName));
		if (menu.isDisplayed()) {
			System.out.println("Menu '" + menuName + "' is accessible");
		} else {
			System.out.println("Menu '" + menuName + "' is not accessible");
		}
	}
	public static void clickOnMenu(String menuName) {
		element= driver.findElement(By.linkText(menuName));
		click(element);


	}

	public static void verifyDemoButton( String button, String menuName) {
		WebElement demoButton = driver.findElement(By.linkText(button));
		if (demoButton.isDisplayed() && demoButton.isEnabled()) {
			System.out.println("Demo button is present and active on '" + menuName + "' page");
		} else {
			System.out.println("Demo button is not present or active on '" + menuName + "' page");
		}
	}

	public static void navigateToContactUs() {
		element=driver.findElement(By.linkText("Contact Us"));
		click(element);
	}

	public static void clickOnMarketingContact() {
		element=driver.findElement(By.xpath("//*[text()='Contact']"));
		click(element);
	}

	public static void completeForm() {	
		getWait();
		element=driver.findElement(By.xpath("//*[text()='Contact']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		click(element);


		// Complete the form excluding the "Message" field

		WebElement  nameElement= driver.findElement(By.name("fullName"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", nameElement);
		enterValue(nameElement, "John Doe");

		WebElement phoneElement=driver.findElement(By.name("cellPhone"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", phoneElement);
		enterValue(phoneElement, "1234567890");

		WebElement emailElement=driver.findElement(By.name("email"));
		waitForElementToBeClickableBool(emailElement, Duration.ofSeconds(20));
		enterValue(emailElement, "johndoe@example.com");


		WebElement organisationElement=driver.findElement(By.xpath("//*[@name='organisationName']"));
		enterValue(organisationElement, "SA TECH");
		scroll_Down();

		WebElement jobrole_Element=driver.findElement(By.xpath("//*[@name='jobRole']"));
//		waitForElementToBeClickableBool(jobrole_Element, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", jobrole_Element);
		Select jobRole= new Select(jobrole_Element);
		jobRole.selectByVisibleText("Executive Board Member");


		WebElement iAgree_element=driver.findElement(By.xpath("//*[text()='I Agree']"));
		waitForElementToBeVisible(By.xpath("//*[text()='I Agree']"), Duration.ofSeconds(20));
		click(iAgree_element);

	}

	public static void submitForm() {
		element=driver.findElement(By.xpath("//button[text()='Submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		click(element);
	}

	public static void isErrorMessageDisplayed() { 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(
				ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//p[text()='Sorry, there was an error submitting the form. Please try again.']")));

	}

	public static void setErrorMessage() {

		if (element.isDisplayed()) {
			System.out.println("Test PASS: Error message is displayed");
		} else {
			System.out.println("Test FAIL: Error message is not displayed");

		}


	}
}

