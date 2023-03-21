package com.spicejet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Soicejet 
{
WebDriver driver;
@Test
public void searchFlight()
{
	WebDriverManager.chromedriver().setup();
	ChromeOptions cp=new ChromeOptions();
	cp.addArguments("--disable-notifications");
	 driver =new ChromeDriver(cp);
driver.get("https://www.spicejet.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//div[text()='round trip']")).click();

driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@type='text']")).sendKeys("DEL");
driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@type='text']")).sendKeys("BLR");

List<WebElement> monthyearlist = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));

int count=0;
for (int i = 0; i < monthyearlist.size(); i++) 
{
	WebElement currentMonthYearElement = monthyearlist.get(i);
	String currentMonthYear = currentMonthYearElement.getText();
	String currentMonth = currentMonthYearElement.getText().split(" ")[0];
	String currentYear = currentMonthYearElement.getText().split(" ")[1];
	if(currentMonth.equals("August") && currentYear.equals("2023"))
	{
		count=i+1;
		break;
	}
}
if(count>=1)
{
	driver.findElement(By.xpath("(//div[text()='23'])["+count+"]")).click();
}
else
	System.out.println("enter a valid month and year");


int count1=0;
for (int i = 0; i < monthyearlist.size(); i++) 
{
	WebElement currentMonthYearElement = monthyearlist.get(i);
	String currentMonthYear = currentMonthYearElement.getText();
	String currentMonth = currentMonthYearElement.getText().split(" ")[0];
	String currentYear = currentMonthYearElement.getText().split(" ")[1];
	if(currentMonth.equals("November") && currentYear.equals("2023"))
	{
		count1=i+1;
		break;
	}
}
if(count1>=1)
{
	driver.findElement(By.xpath("(//div[text()='27'])["+count1+"]")).click();
}
else
	System.out.println("enter a valid month and year");
driver.findElement(By.xpath("//div[text()='Passengers']")).click();
driver.findElement(By.xpath("//div[text()='more than 12 years']"));
WebDriverWait wait =new WebDriverWait(driver,10);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='more than 12 years']"))));
for (int i = 0; i <3; i++) {
	clickOnPassenger("Adult","plus");
}
for (int i = 0; i <2; i++) {
	clickOnPassenger("Children","plus");
}
for (int i = 0; i <7; i++) {
	clickOnPassenger("Infant","plus");
}
driver.findElement(By.xpath("//div[text()='Passengers']")).click();
}			
public void clickOnPassenger(String passengerType,String intdec)
{
driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']//div[text()='"+passengerType+"']/parent::div/following-sibling::div/descendant::div[@data-testid='"+passengerType+"-testID-"+intdec+"-one-cta']")).click();
}								
}


//driver.findElement(By.xpath("//div[text()='From']")).click();
//driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
//for (int i = 0; i<monthyearlist.size(); i++)
//{
//	String monthyear = monthyearlist.get(i).getText();
//	String month = monthyesr.split(" ")[0];
//	String year = monthyesr.split(" ")[1];
//	if(month.equals("August") && year.equals("2023"))
//	{
//		break;
//	}
//	else
//	{
//		try
//		{
//			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-19bllq0 r-u8s1d r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
//	}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
//			
//		}
//	}

