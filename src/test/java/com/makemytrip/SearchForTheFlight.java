package com.makemytrip;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.makemytrip.generic.BaseClass;

public class SearchForTheFlight extends BaseClass
{
@Test
public void searchForFlight()
{
	
	driver.findElement(By.xpath("//a[text()='Search']")).click();
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'OKAY')]"))));
	
	driver.findElement(By.xpath("//button[contains(text(),'OKAY')]")).click();
	driver.findElement(By.xpath("//p[text()='Departure From New Delhi']/following-sibling::div/descendant::div[text()=' AM - ']/b[text()='6']/following-sibling::b[text()='12']/parent::div[text()=' PM']")).click();	//driver.findElement(By.xpath("//p[text()='Popular Filters']/following-sibling::div/descendant::span[contains(text(),'more')]")).click();
//System.out.println(text);
	List<WebElement> flightsdetails = driver.findElements(By.xpath("//p[text()='Popular Filters']/following-sibling::div/descendant::p"));
List<WebElement> flightscheckbox=driver.findElements(By.xpath("//p[text()='Popular Filters']/following-sibling::div/descendant::input[@type='checkbox']"));
for (int i = 0; i <flightsdetails.size(); i++)
{
	String value=flightsdetails.get(i).getText();//Vistara (11) 
	String num = value.replaceAll("[^0-9]","").trim();
	int n=0;
	try {
		 n=Integer.parseInt(num);
	} catch (Exception e) {
		
	}
	
	if(n>4&&n<12)
	{
		flightscheckbox.get(i).click();
	}
}
List<WebElement> flightsName =driver.findElements(By.xpath("//div[@class='fli-list  simpleow ']/descendant::p[@class='boldFont blackText airlineName']|//div[@class='fli-list  simpleow ']/descendant::p[@class='fliCode']"));
List<WebElement> flightstime =driver.findElements(By.xpath("//div[@class='fli-list  simpleow ']/descendant::p[@class='appendBottom2 flightTimeInfo']/span[not(@class='plusDisplayText fontSize9 boldFont redText appendLeft5 textCenter')]"));
for (int i = 0; i<flightsName.size(); i++)
{    String name=flightsName.get(i).getText();
     String departure=flightstime.get(i).getText();
         i++;
		String number=flightsName.get(i).getText();
		String arrival=flightstime.get(i).getText();
		System.out.println("flightname :"+name+"      "+"flightnum :"+number+"    "+"departure :"+departure+"  "+"arrival :"+arrival);
		
}
}
}
