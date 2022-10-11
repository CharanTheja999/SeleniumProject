package com.general.utills;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DriverUtills
{
	public static WebDriver driver;


	public static  WebDriver openbrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\raltheja\\Desktop\\AdminPortal\\AdminPortal\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	   /* ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
	public String getText(String locator) {
		WaitForElementPresent(locator, 8);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		String text = getDriver().findElement(ByLocator(locator)).getText().replaceAll("[\n\r]", "")
				.replaceAll("\\s{2,}", " ").trim();
		return text;
	}
	public List<WebElement> findElements(String locator) {
		WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		List<WebElement> findElements = getDriver().findElements(ByLocator(locator));
		return findElements;
	}
	public void scrollDown(int y) 
	{
		((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + y + ")", "");
	}
	public void scrollSmooth(final int y)
	{
		for (int i = 0; i < y; i++) {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,4)", "");
		}
	}

	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("/")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("(")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.substring(1));
		} else if (locator.startsWith(".")) {
			result = By.id(locator.substring(1));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("xpath=")) {
			result = By.xpath(locator.replace("xpath=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}
	public void sendKeys(String locator, String text) {
		WaitForElementPresent(locator, 8);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));
		WaitForElementEnabled(locator, 20);
		el.clear();
		el.clear();
		el.sendKeys(text);
	}

	public void sendKeysWithoutClear(String locator, String text) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(ByLocator(locator)));
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.clear();
		el.sendKeys(text);
		Thread.sleep(2000);
	}
	public void WaitForElementEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public Boolean isElementPresent(String locator) {
		WebElement element = null;
		try {
			element = getDriver().findElement(ByLocator(locator));
			if (element != null) {

				return true;
			} else {

				return false;
			}
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public Boolean isElementDisplayed(String locator) {
		Boolean result = false;
		try {
			result = getDriver().findElement(ByLocator(locator)).isDisplayed();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public Boolean isClickable(String locator) {
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	public void WaitForElementClickable(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isClickable(locator)) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void moveToGivenElementLocatorByActionClassAndClickByJSE(String locator) {
		WebElement element = getDriver().findElement(ByLocator(locator));
		Actions action = new Actions(getDriver());
		action.moveToElement(element).click();
		action.perform();
	}
	public void WaitForElementNotEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!getDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void mouseOver(String locator) {
		WaitForElementPresent(locator, 50);
		WebElement el = getDriver().findElement(ByLocator(locator));

		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getDriver());
		builder.moveToElement(el).build().perform();
	}
	public String waitForElementNotVisibleUsingExplicitWait(String locator) {
		if ((getDriver() == null) || (locator == null) || locator.isEmpty()) {

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(getDriver(), 25))
					.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(locator)));
			return null;
		} catch (Exception e) {
			return "Build your own errormessage...";
		}
	}
	public String waitForElementNotClickableUsingExplicitWait(String locator) {
		if ((getDriver() == null) || (locator == null) || locator.isEmpty()) {

			return "Wrong usage of WaitforElementNotClickable()";
		}
		try {
			WebElement element = getDriver().findElement(ByLocator(locator));
			(new WebDriverWait(getDriver(), 20)).until(ExpectedConditions.elementToBeClickable(element));
			return null;
		} catch (Exception e)
		{
			return "Element not visible...";
		}
	}
	public void clickOn(String locator) {
		// I have changed wait time from 30 to 20
		WaitForElementPresent(locator, 20);
		waitForElementNotClickableUsingExplicitWait(locator);
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}
	
}
