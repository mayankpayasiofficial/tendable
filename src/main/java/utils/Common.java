package utils;

import org.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Common extends BaseClass {

    /**
     * This method enters value in a text box element
     *
     * @param element
     * @param value
     * @author
     */
    public static void enterValue(WebElement element, String value) {
        try {
            if (element.isDisplayed()) {
                if (element.isEnabled()) {
                    element.click();
                    element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    element.clear();
                    element.sendKeys(value);
                } else {
                    System.out.println("Element is not enabled");
                }
            } else {
                System.out.println("Element is not displayed");
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred while entering value in the element. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * This method clicks on a web element
     *
     * @param element
     * @author 
     */
    public static void click(WebElement element) {
        try {
            if (element.isDisplayed()) {
                if (element.isEnabled()) {
                    if (Common.waitForElementToBeClickableBool(element,Duration.ofSeconds(60))) {
                        element.click();
                    }
                } else {
                    System.out.println("Element is not enabled");
                }
            } else {
                System.out.println("Element is not displayed");
            }
        } catch (
                Exception ex) {
            System.out.println("Exception occurred while clicking on a web element. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * This web element retrieves the text of a web element
     *
     * @param element
     * @return text of a web element
     * @author 
     */
    public static String getTextOfWebElement(WebElement element) {
        String text = "";
        try {
        	Thread.sleep(20000);
            Common.waitForElementVisible(element);
            if (element.isDisplayed()) {
                text = element.getText();
            } else {
                System.out.println("Element is not displayed");
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred while retrieving the text of a web element. " + ex.getMessage());
            ex.printStackTrace();
        }
        return text;
    }

    /**
     * This method is for simple dropdown selection by index
     *
     * @param dropDownID    - This is the unique attribute to find a dropdown element
     * @param dropDownValue - This is the text to search in dropdown
     * @author 
     */
    public static void dropDownSelectionByIndex(By dropDownID, int dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByIndex(dropDownValue);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }

    /**
     * This method is for simple dropdown selection by value
     *
     * @param dropDownID-This    is the unique attribute to find a dropdown element
     * @param dropDownValue-This is the text to search in dropdown
     * @author 
     */
    public static void dropDownSelectionByValue(By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByValue(dropDownValue);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }

    /**
     * This method is for simple dropdown selection by visibleText
     *
     * @param dropDownID-This    is the unique attribute to find a dropdown element
     * @param dropDownValue-This is the text to search in dropdown
     * @author 
     */
    public static void dropDownSelectionByText(By dropDownID, String dropDownValue) {
        try {
            WebElement element = null;
            new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(dropDownID));
            element = driver.findElement(dropDownID);
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(dropDownValue);
        } catch (StaleElementReferenceException ex) {
            System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
        }
    }

    /**
     * This method is used to close all open windows except parent window
     *
     * @return boolean value
     * @throws InterruptedException
     * @author 
     */
    public static boolean closeAllOtherWindows() throws InterruptedException {
        String Parent_Window = driver.getWindowHandle();
        java.util.Set<String> allWindowHandles = driver.getWindowHandles();
        for (String currentWindowHandle : allWindowHandles) {
            if (!currentWindowHandle.equals(Parent_Window)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
                Thread.sleep(2000);
            }
        }
        driver.switchTo().window(Parent_Window);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

    /**
     * This method is used to return system time in seconds
     *
     * @author 
     */
    public static int getCurrentTimeInSeconds() {
        long currentDateMS = new Date().getTime();
        int seconds = (int) ((currentDateMS / 1000) % 3600);
        return seconds;
    }

    /**
     * Selecting Radio Button in Selenium-WebDriver
     *
     * @param webElements
     * @param value
     * @author 
     */
    public static void selectRadioButton(List<WebElement> webElements, String value) {
        for (WebElement element : webElements) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                element.click();
            }
        }

    }
    public static void pause(long milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (Exception ex) {
            System.out.println("Exception occurred. " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void clickOnBackButtonOnBrowser() {
        driver.navigate().back();
        System.out.println("Browser Back button is clicked on");
    }
    
    /**
     * Wait for the element to be clickable ignoring the StaleElementReferenceException
     *
     * @param webElement
     * @param waitTime
     * @return flag
     */
    public static boolean waitForElementToBeClickableBool(WebElement webElement, Duration waitTime) {
        boolean flag = false;
        try {
        	
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(webElement));
            flag = true;

        } catch (Exception ex) {
            flag = false;
            System.out.println("Exception occurred while waiting for the element to be clickable ignoring the StaleElementReferenceException. " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }

    /**
     * This method is used to wait for element till visibility of element.
     *
     * @param attributeValue - locator value of element till it is visible on
     *                       application and then click that element.
     * @param waitTime       -  maximum wait time in seconds for driver
     */
    public static boolean waitForElementToBeVisible(By attributeValue, Duration waitTime) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
            flag = true;

        } catch (Exception ex) {
            flag = false;
            System.out.println("Exception occurred while waiting for the element for element till visibility of element. " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }

    /**
     * This method is used to wait for the Alert present ignoring the StaleElementReferenceException
     *
     * @param waitTime
     * @return flag
     */
    public boolean waitForAlertPresent(Duration waitTime) {
        boolean flag = false;
        new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.alertIsPresent());
        try {
            driver.switchTo().alert();
            flag = true;
        } catch (Exception ex) {
            flag = false;
            System.out.println("Exception occurred while waiting for the Alert present ignoring the StaleElementReferenceException. " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }

    public static Wait<WebDriver> getWait() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        return wait;
    }

    public static void waitForElementVisible(WebElement ele) {
        Wait<WebDriver> wait = getWait();
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void javaScript_click(WebElement ele) {
        try {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", ele);
        }catch(Exception E){}
    }

    public static void scroll_Up() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,-350)", "");
    }

    public static void scroll_Down(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }
}
