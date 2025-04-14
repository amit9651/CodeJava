package grouping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class test01 {

    
	@Test
    public void hdfcbank(){	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.hdfcbank.com/");
    	driver.manage().window().maximize();
    	WebElement loginbtn = driver.findElement(By.xpath("//button[@type=\"button\" and text()=\"Login\" and @ng-if=\"mainctrl.loginmenuClosed\"]"));
    	//WebElement netbanking = driver.findElement(By.xpath("//div[@class=\"dropdown_list\"]//a[text()=\"NetBanking\"]"));
    	Actions action = new Actions(driver);
    	action.moveToElement(loginbtn).moveToElement(driver.findElement(By.xpath("//div[@class=\"dropdown_list\"]//a[text()=\"NetBanking\"]"))).click().perform();
    	
    	
    
	}
	
	@Test
    public void hdfcbankother(){	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.hdfcbank.com/");
    	driver.manage().window().maximize();
    	WebElement loginbtn = driver.findElement(By.xpath("//button[@type=\"button\" and text()=\"Login\" and @ng-if=\"mainctrl.loginmenuClosed\"]"));
    	//WebElement netbanking = driver.findElement(By.xpath("//div[@class=\"dropdown_list\"]//a[text()=\"NetBanking\"]"));
    	//Actions action = new Actions(driver);
    	//action.moveToElement(loginbtn).perform();
    	loginbtn.click();
    	driver.findElement(By.xpath("//div[@class=\"dropdown_list\"]//a[text()=\"NetBanking\"]")).click();
    	
    
	}

}
