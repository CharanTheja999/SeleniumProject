package com.stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.general.utills.ConfiguratorSupport;
import com.general.utills.DriverUtills;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SubscribedStepDef
{

	public static WebDriver driver=null;

	@Given("User enter STCtv URL")
	public void user_enter_st_ctv_url() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ConfiguratorSupport.getProperty("DemoURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//a[@class='header-btns-country hide-mobile']")).click();
		//driver.findElement(By.xpath("//a[@href='https://subscribe.stctv.com/bh-en']")).click();
	}

	@Then("Validate STCtv home page displayed correctly and title matches")
	public void validate_st_ctv_home_page_displayed_correctly_and_title_matches()
	{

		System.out.println("Title of The page=========> "+driver.getTitle());
	}

	@Given("User to validate title of the page")
	public void user_to_validate_title_of_the_page() 
	{
		String actualtitle=ConfiguratorSupport.getProperty("ActualTitle");
		System.out.println("Actual Title of the page =====>"+actualtitle.trim());
	}

	@Then("Validate Bahrain Subscription Packages and price populated correctly")
	public void validate_bahrain_subscription_packages_and_price_populated_correctly() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='header-btns-country hide-mobile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://subscribe.stctv.com/bh-en']")).click();
		Thread.sleep(1000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='package-container']/div/h1"));
		int dataSize=list.size();
		for(int i=0;i<dataSize;i++)
		{
			String data=list.get(i).getText();
			System.out.println("Values =======> "+data);
			String str[]= {"LITE","CLASSIC","PREMIUM"};
			if(data.equalsIgnoreCase(str[i]))
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
				List<WebElement> priceDigit=driver.findElements(By.xpath("//div[@class='price']/span[1]"));
				System.out.println("Size"+priceDigit.size());
				for(int k=0;k<=priceDigit.size()-1;k++)
				{
					String priceD=priceDigit.get(k).getText();
					System.out.println("BHD Each Package Value"+priceD);
					String strprice[]= {"2","3","6"};
					if(priceD.equalsIgnoreCase(strprice[k]))
					{
						System.out.println("Matching value: " + priceDigit.get(i).getText() + " : : " + strprice[k]);
					}

				}
				WebElement we=driver.findElement(By.xpath("(//div[@class='package-container']/div/div[1])["+(i+1)+"]"));
				String valueInfo=we.getText().trim();
				if(valueInfo.contains("BHD"))
				{
					System.out.println("Bahrain Currency populated correctly");
				}
				
			}
			else
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
			}
		}
	
	}

	@Then("Validate KSA Subscription Packages and price populated correctly")
	public void validate_ksa_subscription_packages_and_price_populated_correctly() throws InterruptedException 
	{
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='header-btns-country hide-mobile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://subscribe.stctv.com/sa-en']")).click();
		Thread.sleep(1000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='package-container']/div/h1"));
		int dataSize=list.size();
		for(int i=0;i<dataSize;i++)
		{
			String data=list.get(i).getText();
			System.out.println("Values =======> "+data);
			String str[]= {"LITE","CLASSIC","PREMIUM"};
			if(data.equalsIgnoreCase(str[i]))
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
				List<WebElement> priceDigit=driver.findElements(By.xpath("//div[@class='price']/span[1]"));
				System.out.println("Size"+priceDigit.size());
				for(int k=0;k<=priceDigit.size()-3;k++)
				{
					String priceD=priceDigit.get(k).getText();
					System.out.println("KSA Each Package Value"+priceD);
					String strprice[]= {"15","25","60"};
					if(priceD.equalsIgnoreCase(strprice[k]))
					{
						System.out.println("Matching value: " + priceDigit.get(i).getText() + " : : " + strprice[k]);
					}

				}
				WebElement we=driver.findElement(By.xpath("(//div[@class='package-container']/div/div[1])["+(i+1)+"]"));
				String valueInfo=we.getText().trim();
				if(valueInfo.contains("SAR"))
				{
					System.out.println("KSA Currency populated correctly");
				}
				
			}
			else
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
			}
		}


	}

	@Then("Validate Kuwait Subscription Packages and price populated correctly")
	public void validate_kuwait_subscription_packages_and_price_populated_correctly() throws InterruptedException 
	{

		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='header-btns-country hide-mobile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://subscribe.stctv.com/kw-en']")).click();
		Thread.sleep(1000);
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='package-container']/div/h1"));
		int dataSize=list.size();
		for(int i=0;i<dataSize;i++)
		{
			String data=list.get(i).getText();
			System.out.println("Values =======> "+data);
			String str[]= {"LITE","CLASSIC","PREMIUM"};
			if(data.equalsIgnoreCase(str[i]))
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
				List<WebElement> priceDigit=driver.findElements(By.xpath("//div[@class='price']/span[1]"));
				System.out.println("Size"+priceDigit.size());
				for(int k=0;k<=priceDigit.size()-1;k++)
				{
					String priceD=priceDigit.get(k).getText();
					System.out.println("Kuwait Each Package Value"+priceD);
					String strprice[]= {"1.2","2.5","4.8"};
					if(priceD.equalsIgnoreCase(strprice[k]))
					{
						System.out.println("Matching value: " + priceDigit.get(i).getText() + " : : " + strprice[k]);
					}

				}
				WebElement we=driver.findElement(By.xpath("(//div[@class='package-container']/div/div[1])["+(i+1)+"]"));
				String valueInfo=we.getText().trim();
				if(valueInfo.contains("KWD"))
				{
					System.out.println("Kuwait Currency populated correctly");
				}
				
			}
			else
			{
				System.out.println("Matching value: " + list.get(i).getText() + " : : " + str[i]);
			}
		}
	}

}
