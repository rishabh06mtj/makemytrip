package com.makemytrip.generic;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverUtility 
{
	private WebDriver driver;
	private WebDriverWait wait;

	

	public WebDriver launchApplication(String browser,long timeout,String url)
	{    
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please enter valid browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public void visibilityOfElement(long timeout,WebElement element) {
		wait=new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	public void swithToWindow(WebDriver driver , String partialWindowTitle) { 
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();

	while (it.hasNext()) 
	{
	String wID = it.next(); driver.switchTo().window(wID);
	String currentWindowTitle = driver.getTitle(); 
	if(currentWindowTitle.contains(partialWindowTitle)) 
	{ 
		break;
	}
	}
	}
	
	public void action_mouseHover(WebElement element)
	{
		Actions a =new Actions(driver);
		a.moveToElement(element).perform();

	}
	public void implicitlyWait()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	
	public void closeBrowser()
	{
		driver.quit();
	}



}