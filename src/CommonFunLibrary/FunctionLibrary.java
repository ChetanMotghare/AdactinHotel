package CommonFunLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Utilities.PropertyFileUtil;

public class FunctionLibrary 
{
	   public static  WebDriver driver;
	   
	   //method to launch browser
	   
	   public static WebDriver startBrowser() throws Throwable
	   {
		  
		   if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome")) //launching chromedriver
		     {
			       System.setProperty("webdriver.chrome.driver", "D:\\OJTSelenium\\Adactin\\CommonDriver\\chromedriver.exe");
			       driver = new ChromeDriver();
			       driver.manage().window().maximize();
		     }
		   else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))  // Launching firfox driver
		   {
			   System.setProperty("webdriver.gecko.driver", "D:\\OJTSelenium\\Adactin\\CommonDriver\\geckodriver.exe");
			   driver = new FirefoxDriver();
			   driver.manage().window().maximize();
			   driver.manage().deleteAllCookies();
		   }
		   else
		   {
			   Reporter.log("Browser value not match",true);
		   }
		   return driver;
	   }
	   
	   //Method to opening URL
	   
	   public static void openApplication(WebDriver driver) throws Throwable
	   {
		   driver.get(PropertyFileUtil.getValueForKey("URL"));
	   }
	   
	   //method for wait element
	   
	   public static void waitForElement(WebDriver driver,String locatortype,String locatorvalue,String waitime)
	   {
		   WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitime));
		   
		   if(locatortype.equalsIgnoreCase("id"))
		   {
			   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorvalue)));
		   }
		   else if(locatortype.equalsIgnoreCase("name"))
		   {
			   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locatorvalue)));
		   }
		   else if(locatortype.equalsIgnoreCase("xpath"))
		   {
			   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorvalue)));
		   }
	   }
	   
	   //method for typeaction
	   
	   public static void typeAction(WebDriver driver,String locatortype,String locatorvalue,String data)
	   {
		   if(locatortype.equalsIgnoreCase("id"))
		   {
			   driver.findElement(By.name(locatorvalue)).clear();
			   driver.findElement(By.id(locatorvalue)).sendKeys(data);
		   }
		   else if(locatortype.equalsIgnoreCase("name"))
		   {
			   driver.findElement(By.name(locatorvalue)).clear();
			   driver.findElement(By.name(locatorvalue)).sendKeys(data);
		   }
		   else if(locatortype.equalsIgnoreCase("xpath"))
		   {
			   driver.findElement(By.name(locatorvalue)).clear();
			   driver.findElement(By.name(locatorvalue)).sendKeys(data);
		   }
	   }

	   // method for clickAction
	   
	   public static void clickAction(WebDriver driver,String locatortype,String locatorvalue)
	   {
		   if(locatortype.equalsIgnoreCase("id"))
		   {
			   driver.findElement(By.name(locatorvalue)).sendKeys(Keys.ENTER);
			   
		   }
		   else if(locatortype.equalsIgnoreCase("name"))
		   {
			   driver.findElement(By.name(locatorvalue)).click();
			   
		   }
		   else if(locatortype.equalsIgnoreCase("xpath"))
		   {
			   driver.findElement(By.name(locatorvalue)).sendKeys(Keys.ENTER);
		   }
		}
	   
	   //method for title validation
	   
	   public static void titleValidation(WebDriver driver,String exp_title)
	   {
		   String act_title = driver.getTitle();
		   Assert.assertEquals(act_title, exp_title);
	   }
	   
	   //close browser
	   
	   public static void closeApplication(WebDriver driver)
	   {
		   driver.close();
	   }
	   
	   public static String  generateDate()
	   {
		   Date date = new Date();
		   SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_ss");
		   return sdf.format(date);
		   
	   }
}
