package Selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AllTest {
	
	WebDriver driver = new ChromeDriver();
	
	
	
	@Test
	public void getMethods() {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String parentWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		/*while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		for(String window: ids) {
			System.out.println(window);
			if(!window.contentEquals(parentWindow)){
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				System.out.println(window);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		
		driver.quit();
		
		
	}
	
	@Test
	public void conditionalMethods() {
		
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		System.out.println("Logo is visible: "+driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed());
		System.out.println("First name field is enabled :"+driver.findElement(By.id("FirstName")).isEnabled());
		if(!driver.findElement(By.id("gender-male")).isSelected()) {
			driver.findElement(By.id("gender-male")).click();
			System.out.println("Male checkbox is now selected :"+driver.findElement(By.id("gender-male")).isSelected());
		}
		
		if(!driver.findElement(By.id("gender-female")).isSelected()) {
			driver.findElement(By.id("gender-female")).click();
			System.out.println("Female checkbox is now selected :"+driver.findElement(By.id("gender-female")).isSelected());
			System.out.println("Male checkbox is now selected :"+driver.findElement(By.id("gender-male")).isSelected());
		}
		driver.quit();
	}
	
	
	@Test
	public void navigationCommands() throws MalformedURLException {
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
		driver.navigate().back();
		driver.navigate().refresh();
		URL url = new URL("https://demo.nopcommerce.com/login");
		driver.navigate().to(url);
		driver.quit();
		
		
	}
	
	@Test
	public void assignment01() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input.wikipedia-search-input")).sendKeys("amit");
		driver.findElement(By.cssSelector("input.wikipedia-search-button")).click();
		List<WebElement> res = driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']"));
		WebElement more = driver.findElement(By.xpath("//a[text()='More »']"));
		System.out.println("Total Search results for amit :"+(res.size()+1));
		
		for(WebElement str:res) {
			String text = str.getText();
			driver.findElement(By.linkText(text)).click();
		}
		more.click();
		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		
		for(String it: set) {
			String title = driver.switchTo().window(it).getTitle();
			if(title.equals("Amitriptyline - Wikipedia") || title.equals("Amit Shah - Wikipedia")) {
				driver.close();
				System.out.println("Window closed for title :"+title);
			}
		}
		driver.switchTo().window(parent);
		System.out.println("driver returned to parent window :"+driver.getTitle());
		driver.quit();
		
		
	}
	
	@Test
	public void alerts() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert myalert = driver.switchTo().alert();
		System.out.println("Normal Alert text: "+myalert.getText());
		myalert.accept();
		System.out.println("Result: "+driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Alert myalert2 = driver.switchTo().alert();
		System.out.println("Confirmation Alert text: "+myalert2.getText());
		myalert2.accept();
		System.out.println("Result: "+driver.findElement(By.xpath("//p[@id='result']")).getText());
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Result: "+driver.findElement(By.xpath("//p[@id='result']")).getText());
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Alert myalert3 = driver.switchTo().alert();
		myalert3.sendKeys("amit");
		myalert3.accept();
		System.out.println("Result: "+driver.findElement(By.xpath("//p[@id='result']")).getText());

		
		
		driver.quit();
	}
	
	@Test
	public void handleAlertWithExplicitWait() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		System.out.println("Result: "+driver.findElement(By.xpath("//p[@id='result']")).getText());
		driver.quit();
	}
	
	@Test
	public void authenticationPopup() {
		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		System.out.println("Auth message: "+driver.findElement(By.xpath("//div[@class='example']/child::p")).getText());
		driver.quit();
	}
	
	
	@Test
	public void makeMyTrip() {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("8575435");
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		driver.quit();
		
		
	}
	
	@Test
	public void assignmenttwo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement el = driver.findElement(By.xpath("//h2[normalize-space()='Pagination Web Table']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", el);
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
		int j=3;
		for(int i=0;i<list.size();i++) {
			String xpath = "//table[@id='productTable']/tbody/tr["+(i+1)+"]"+"/td["+j+"]";
			String price = driver.findElement(By.xpath(xpath)).getText();
			String actualPrice = price.substring(1,price.length()-1);
			Double value = Double.parseDouble(actualPrice);
			if(value>=5.0 && value<=10.0) {
				String xpathbox = "//table[@id='productTable']/tbody/tr["+(i+1)+"]"+"/td["+(j+1)+"]/input";
				System.out.println(xpathbox);
				driver.findElement(By.xpath(xpathbox)).click();
			}
		}
		driver.quit();
		
	}
	
	
	@Test
	public void frame() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		WebElement el = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(el);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("frame01");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("frame02");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']")));
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("frame03");
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true']")));
		
		WebElement text = driver.findElement(By.xpath("//span[normalize-space()='Form Autofilling']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", text);
		text.click();
		
		driver.quit();
		
	}
	
	@Test
	public void dropdowns() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement dd = driver.findElement(By.id("country"));
		Select sel = new Select(dd);
		sel.selectByValue("australia");
		List<WebElement> options = sel.getOptions();
		System.out.println("Total dropdown values: "+options.size());
		for(WebElement el:options) {
			System.out.println(el.getText());
		}
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		driver.findElement(By.xpath("//li//input[@value='Java']")).click();
		driver.findElement(By.xpath("//li//input[@value='csharp']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		driver.quit();
		

	}
	
	@Test
	public void captureAllDropdownValue() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		List<WebElement> alloptions = driver.findElements(By.xpath("//label[@class='checkbox']"));
		for(WebElement opt:alloptions) {
			if(!opt.getText().equals("HTML") && !opt.getText().equals("CSS") ) {
				opt.click();
				System.out.println(opt.getText());
			}
		}
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		driver.quit();
		
	}
	
	
	@Test
	public void dynamicDropdown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//label[text()='Job Title']/parent::div/parent::div//div[2]//div/div/div[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Software Engineer']")).click();
		driver.quit();

		

	}
	
	
	@Test
	public void getTextInPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.xpath("//div[@class='main-outer']")).getText());
		driver.quit();

	}
	
	
	@Test
	public void clickInAutoSuggestDD() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//span[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iphone");
		List<WebElement> phones = driver.findElements(By.xpath("//li[@class='_3D0G9a']"));
		System.out.println(phones.size());
		for(WebElement ph:phones) {
			
			if(ph.getText().equals("iphone 16e")){
				System.out.println(ph.getText());
				ph.click();
				break;
			}
		}

		System.out.println(driver.findElement(By.xpath("//div[@class='col col-7-12']//div[@class='KzDlHZ'][1]")).getText());
		driver.quit();

		
	}
	
	
	@Test
	public void staticWebTable() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//h2[text()='Static Web Table']")));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		int rowcount = rows.size();
		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		int colcount = cols.size();
		System.out.println("Total rows in table: "+rowcount);
		System.out.println("Total columns in table: "+colcount);
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=1;j<=colcount;j++) {
				if(i==1) {
					System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/th["+j+"]")).getText()+" ");
				}
				else {
					System.out.print(driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
				}
			}
			System.out.println("");
			
		}
		driver.quit();
		
		
	}
	
	@Test
	public void assignment3() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		sel1.selectByValue("Boston");
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		sel2.selectByValue("Dublin");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tr"));
		int totrows = rows.size();
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='table']//tr/th"));
		int totcols = cols.size();
		double minPrice = Double.MAX_VALUE;
		int index = 0;
		for(int i=1;i<totrows;i++) {
			String price = driver.findElement(By.xpath("//table[@class='table']//tr["+i+"]/td[6]")).getText();
			System.out.println("prices of flight: "+price);
			String actualprice = price.substring(1);
			System.out.println(actualprice);
			if(minPrice > Double.parseDouble(actualprice)) {
				minPrice = Double.parseDouble(actualprice);
				index = i;
			}
		}
		
		driver.findElement(By.xpath("//table[@class='table']//tr["+index+"]/td[1]/input")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("inputName")).sendKeys("Amit");
		driver.findElement(By.id("address")).sendKeys("sec-73");
		driver.findElement(By.id("city")).sendKeys("Noida");
		driver.findElement(By.id("state")).sendKeys("UP");
		driver.findElement(By.id("zipCode")).sendKeys("201301");
		Select s3 = new Select(driver.findElement(By.id("cardType")));
		s3.selectByValue("amex");
		driver.findElement(By.id("creditCardNumber")).sendKeys("7539749242084302");
		WebElement pbtn = driver.findElement(By.xpath("//input[@value='Purchase Flight']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", pbtn);
		driver.findElement(By.id("nameOnCard")).sendKeys("modiii");
		driver.findElement(By.id("rememberMe")).click();
		pbtn.click();
		System.out.println("Purchase status: "+driver.findElement(By.xpath("//h1")).getText());
		System.out.println("Order ID: "+driver.findElement(By.xpath("//table//tr[1]/td[2]")).getText());
		driver.quit();


	}
	
	
	@Test
	public void datePicker() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("03/23/2025");
		driver.findElement(By.xpath("//input[@id='datepicker']")).clear();
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String year = "2024";
		String month = "March";
		String day = "29";
		
		while(!(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month) && driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().equals(year))) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			
		}
		driver.findElement(By.xpath("(//td[@data-handler='selectDay'])["+day+"]")).click();
		driver.quit();
		
		
		
	}
	
	
	@Test
	public void actionMethods() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.browserstack.com/");
		
		driver.manage().window().maximize();
		
		WebElement products = driver.findElement(By.xpath("//button[normalize-space()='Products']"));
		WebElement livetesting = driver.findElement(By.xpath("//span[normalize-space()='Live']/following-sibling::div[text()='Cross-browser testing ']"));
		Actions action = new Actions(driver);
		action.moveToElement(products).moveToElement(livetesting).click().build().perform();
		
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo/input.html");
		WebElement rightclick = driver.findElement(By.xpath("//span[.='right click me']"));
		action.contextClick(rightclick).perform();
		driver.navigate().to("https://qa-practice.netlify.app/double-click");
		WebElement doubleclick = driver.findElement(By.id("double-click-btn"));
		action.doubleClick(doubleclick).perform();
		
	}
	
	
	@Test
	public void draganddrop() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//div[@id='box6' and .='Rome']"));
		WebElement target = driver.findElement(By.xpath("//div[@class='dragableBoxRight' and .='Italy']"));
		//action.clickAndHold(source).moveToElement(target).release().build().perform();
		//OR
		action.dragAndDrop(source, target).perform();
		
	}
	
	
	
	
	
	
	

}
