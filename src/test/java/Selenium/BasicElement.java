package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;


	public class BasicElement {
	
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SoftAssert soft = new SoftAssert();
	
	@BeforeClass
	public void setUp() {
		
	}
	
    
	
	@BeforeMethod
	public void OpenSiteDemoQA() {
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
	}
	
	@Test
	public void clickElements() throws InterruptedException, MalformedURLException, IOException {
		WebElement element = driver.findElement(By.xpath("//h5[text()='Elements']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		element.click();
		WebElement tools;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		tools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/images/Toolsqa.jpg']")));
		System.out.println(tools);
		
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		js.executeScript("arguments[0].scrollIntoView();", submit);
		boolean textBox = driver.findElement(By.xpath("//h1[text()='Text Box']")).isDisplayed();
		System.out.println("Text is present on screen: "+textBox);
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys("Amit Singh");
		driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys("amit17@gmail.com");
		driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("sec-73, Noida");
		driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys("fatehgarh, U.P");
		js.executeScript("arguments[0].scrollIntoView(true);", submit);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebElement checkBx = driver.findElement(By.xpath("//span[text()='Check Box']"));
		//js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		driver.get("https://demoqa.com/elements");
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();
		boolean checkBox = driver.findElement(By.xpath("//h1[text()='Check Box']")).isDisplayed();
		System.out.println("Check is visible: "+checkBox);
		driver.findElement(By.xpath("//span[text()='Home']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'rct-option rct-option-expand-all')]")).click();
		
		
		
		
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		WebElement radioBtn = driver.findElement(By.xpath("//h1[text()='Radio Button']"));
		wait.until(ExpectedConditions.visibilityOf(radioBtn));
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		WebElement radioButton = driver.findElement(By.id("yesRadio"));
		System.out.println("radiobtn: "+radioButton.isSelected());
		
		
		
		
		driver.get("https://demoqa.com/webtables");
		boolean webTable = driver.findElement(By.xpath("//h1[text()='Web Tables']")).isDisplayed();
		System.out.println("Web Table is visible: "+webTable);
		driver.findElement(By.id("addNewRecordButton")).click();
		System.out.print(driver.findElement(By.id("registration-form-modal")).isDisplayed());
		driver.findElement(By.id("firstName")).sendKeys("Amit");
		driver.findElement(By.id("lastName")).sendKeys("Singh");
		driver.findElement(By.id("userEmail")).sendKeys("amit@test.com");
		driver.findElement(By.id("age")).sendKeys("26");
		driver.findElement(By.id("salary")).sendKeys("1290");
		driver.findElement(By.id("department")).sendKeys("QA");
		driver.findElement(By.id("submit")).click();
		System.out.println("first name is present: "+driver.findElement(By.xpath("//div[text()='Amit']")).isDisplayed());
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div"));
		int n = list.size();
		System.out.println("Size: "+n);
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
		List<WebElement> list3 = driver.findElements(By.xpath("//div[@class='rt-td']"));
		int n2 = list2.size();
		int n3 = list3.size();
		for(WebElement el1: list2) {
			System.out.print(el1.getText());
			System.out.print("   ");
		}
		System.out.println("");
		int k=0;
		for(int i=0;i<10;i++) {
			
			for(int j=0;j<7;j++) {
			
			
			String val = list3.get(k).getText();
			System.out.print(val);
			System.out.print(" ");
			k++;
			}
			if(k==28) {
				break;
			}
			System.out.println("");
		}
		
		driver.get("https://demoqa.com/buttons");
		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClick).perform();
		String msg1 = driver.findElement(By.id("doubleClickMessage")).getText();
		System.out.println(msg1);
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		actions.contextClick(rightClick).perform();
		String msg2 = driver.findElement(By.id("rightClickMessage")).getText();
		System.out.println(msg2);
		WebElement dbl = driver.findElement(By.xpath("//button[text()='Click Me']"));
		js.executeScript("arguments[0].scrollIntoView(true);", dbl);
		WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		click.click();
		String msg3 = driver.findElement(By.id("dynamicClickMessage")).getText();
		System.out.println(msg3);
		
		driver.get("https://demoqa.com/links");
		String currentHandle = driver.getWindowHandle();
		driver.findElement(By.id("simpleLink")).click();
		Set<String> set = driver.getWindowHandles();
		
		for(String val: set) {
			if(val!=currentHandle) {
				driver.switchTo().window(val);
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				break;
			}
		}
		//driver.close();
		driver.switchTo().window(currentHandle);
		
		driver.get("https://demoqa.com/broken");
		List<WebElement> ls = driver.findElements(By.tagName("img"));
		
		for(WebElement ele: ls) {
			String imgUrl = ele.getAttribute("src");
			imgUrl = "https://demoqa.com/"+imgUrl;
			HttpURLConnection connection = (HttpURLConnection) new URL(imgUrl).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			if(responseCode >= 400) {
				System.out.println("BROKEN IMAGE: "+imgUrl+"-"+responseCode);
			}
			else {
				System.out.println("VALID IMAGE: "+imgUrl+"-"+responseCode);
			}
		}
		
		/*
		 * List<WebElement> hrfs = driver.findElements(By.tagName("a")); for(WebElement
		 * links : hrfs) { String url2 = links.getAttribute("href"); URL link = new
		 * URL(url2); HttpURLConnection connection = (HttpURLConnection)
		 * link.openConnection(); connection.connect();
		 * 
		 * int code = connection.getResponseCode(); if(code == 200) {
		 * System.out.println("Valid link: "+links); } else {
		 * System.out.println("Broken link: "+links); } }
		 */
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterClass
	public void endsetUp() {
		//driver.quit();
	}
    
}

