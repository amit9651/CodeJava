package Selenium;

import java.time.Duration;
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
	
    
	
	@Test(priority = 1)
	public void OpenSiteDemoQA() {
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
	}
	
	@Test(priority = 2)
	public void clickElements() throws InterruptedException {
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
		WebElement radioButton = driver.findElement(By.xpath("//label[text()='Yes']"));
		System.out.println("radiobtn: "+radioBtn.isSelected());
		
		
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		
	}
	
	@AfterClass
	public void endsetUp() {
		//driver.quit();
	}
    
}

