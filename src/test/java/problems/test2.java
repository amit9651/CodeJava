package problems;

import dev.failsafe.internal.util.Durations;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.*;

public class test2 {
    String userDir = System.getProperty("user.dir");
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String[] sizes = {"S","M","L","XS","ML","XL","XXL"};
            driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
            for(int i=0;i<sizes.length;i++) {
                String xpath = "//span[@class = 'checkmark' and text()='"+sizes[i]+"']";
                //System.out.println(xpath);
                driver.findElement(By.xpath(xpath)).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                Thread.sleep(5000);
                WebElement el1 = driver.findElement(By.xpath("//p[text()=' Product(s) found' ]"));
                wait.until(ExpectedConditions.visibilityOf(el1));
                List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'sc-124al1g-3 bHJSNa' and text()='Free shipping']"));
                System.out.println("Total count of Size "+sizes[i]+": "+products.size());
                driver.navigate().refresh();
                driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
               
            }
            driver.quit();
    }



    @Test
    public void getMethods() {

        WebDriver driver = new ChromeDriver();

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

        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
        System.out.println("Auth message: "+driver.findElement(By.xpath("//div[@class='example']/child::p")).getText());
        driver.quit();
    }


    @Test
    public void makeMyTrip() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("8575435");
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        driver.quit();


    }

    @Test
    public void assignmenttwo() {
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        System.out.println(driver.findElement(By.xpath("//div[@class='main-outer']")).getText());
        driver.quit();

    }


    @Test
    public void clickInAutoSuggestDD() {
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        WebDriver driver = new ChromeDriver();

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
        driver.quit();
    }


    @Test
    public void draganddrop() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//div[@id='box6' and .='Rome']"));
        WebElement target = driver.findElement(By.xpath("//div[@class='dragableBoxRight' and .='Italy']"));
        //action.clickAndHold(source).moveToElement(target).release().build().perform();
        //OR
        action.dragAndDrop(source, target).perform();
        driver.quit();
    }



    @Test
    public void slider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        driver.manage().window().maximize();
        WebElement leftslider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        WebElement rightslider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        System.out.println(leftslider.getLocation());
        System.out.println(rightslider.getLocation());
        Actions action = new Actions(driver);
        action.dragAndDropBy(leftslider, 100, 259).perform();
        action.dragAndDropBy(rightslider, -115, 259).perform();
        driver.navigate().refresh();
        WebElement leftslider2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
        WebElement rightslider2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Thread.sleep(3000);
        action.clickAndHold(leftslider2).moveByOffset(143, 259).perform();
        action.clickAndHold(rightslider2).moveByOffset(-156, 259).perform();
        driver.quit();

    }

    @Test
    public void keyboardactions() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://text-compare.com/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//textarea[@placeholder='Paste one version of a text here.']")).sendKeys("Welocme to selenium");
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        //NYKAA
        driver.get("https://www.nykaa.com/");
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search on Nykaa']"));
        search.sendKeys("Tshirts");
        driver.quit();


    }

    @Test
    public void nykaa() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.nykaa.com/");
        driver.manage().window().maximize();
        //NYKAA
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search on Nykaa']"));
        search.sendKeys("Tshirts",Keys.ENTER);
        driver.quit();


    }


    @Test
    public void javascriptexecutor() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.id("name"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','Amit')", name);
        WebElement gender = driver.findElement(By.id("male"));
        js.executeScript("arguments[0].click()", gender);
        driver.quit();

    }

    @Test
    public void javascriptexecutorScrolling() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //scroll by pixels
        js.executeScript("window.scrollBy(0,500)", "");
        System.out.println(js.executeScript("return window.pageYOffset;"));
        //scrolling to element
        WebElement scroll = driver.findElement(By.xpath("//h2[.='Dynamic Web Table']"));
        js.executeScript("arguments[0].scrollIntoView();", scroll);
        System.out.println(js.executeScript("return window.pageYOffset;"));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(js.executeScript("return window.pageYOffset;"));
        driver.quit();

    }

    @Test
    public void uploadfile() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();
        WebElement file = driver.findElement(By.id("filesToUpload"));
        file.sendKeys("/Users/amitsingh/Downloads/CodeJava/fileone.png");
        String filename = "fileone.png";
        if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals(filename)) {
            System.out.println("file uploaded successfully!");
        }
        else {
            System.out.println("error in uploading file");
        }
        driver.quit();

    }


    @Test
    public void takeScrennshort() {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(userDir+"/screenshots/fullpagess.png");
        source.renameTo(target);
        driver.quit();
    }

    @Test
    public void chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.quit();
    }

    @Test
    public void handleSSL(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://expired.badssl.com/");
        System.out.print(driver.getTitle());
        driver.quit();
    }

    @Test
    public void incognitoMode(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://expired.badssl.com/");
        System.out.print(driver.getTitle());
        driver.quit();
    }

    @Test
    public void enableExtension(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        options.setAcceptInsecureCerts(true);
        File file = new File(userDir+"/AdBlock.crx");
        options.addExtensions(file);
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.print(driver.getTitle());
        driver.quit();
    }

    @Test
    public void brokenLinks() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found on page: "+links.size());
        int count=0;
        for(int i=0;i<links.size();i++){
            String urlText = links.get(i).getAttribute("href");
            int code=0;
            if(!urlText.isEmpty()){
                try {
                    URL url = new URL(urlText);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    code = connection.getResponseCode();
                }
                catch (UnknownHostException e){
                    System.out.println((i+1)+e.getMessage());
                }
                catch (ClassCastException e){
                    System.out.print((i+1)+e.getMessage());
                }
                if(code >=400){
                    System.out.println((i+1)+".Link is broken: "+urlText+" Status Code: "+code);
                    count++;
                }
                else{
                    System.out.println((i+1)+".Link is working: "+urlText+" Status Code: "+code);
                }
            }
            else{
                System.out.println((i+1)+".No link url present for: "+urlText);
            }
        }
        System.out.println("Total broken links: "+count);
        driver.quit();

    }

    @Test
    public void shadowDomElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://dev.automationtesting.in/shadow-dom");
        //Single shadow dom
        SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        String shadowText = shadow.findElement(By.cssSelector("#shadow-element")).getText();
        Thread.sleep(3000);
        System.out.println("Shadow DOM Element text: "+shadowText);
        //Nested Shadown dom
        SearchContext  nestedShadow = shadow.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        String nestedShadowDom = nestedShadow.findElement(By.cssSelector("#nested-shadow-element")).getText();
        System.out.println("nestedShadowDom text: "+nestedShadowDom);
        //multi-nested Shadow dom
        SearchContext multiNestedShadow = nestedShadow.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        String multiNestedShadowDom = multiNestedShadow.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
        System.out.println("multiNestedShadowDom text: "+multiNestedShadowDom);
        driver.quit();
    }

    @Test
    public void svgElement(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']//*[name()='svg']")).click();
        driver.quit();
    }

    @Test
    public void readExcelFile() throws IOException {
        FileInputStream fileInput = new FileInputStream(userDir+"/testdata/testfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
        XSSFSheet sheet = workbook.getSheet("Car");
        int totalRows = sheet.getLastRowNum();
        int totalColoumns = sheet.getRow(1).getLastCellNum();
        System.out.println("Total rows: "+totalRows);
        System.out.println("Total coloumns :"+totalColoumns);

        for(int r=0;r<=totalRows;r++){
            XSSFRow rowData = sheet.getRow(r);
            for(int c=0;c<totalColoumns;c++){
                XSSFCell cellData = rowData.getCell(c);
                System.out.print(cellData.toString()+" ");
            }
            System.out.println("");
        }
        workbook.close();
        fileInput.close();
    }

    @Test
    public void writeExcelFile() throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(userDir+"/testdata/writetestfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
        XSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("Java");
            row1.createCell(1).setCellValue("23");
            row1.createCell(2).setCellValue("Automation");
        XSSFRow row2 = sheet.createRow(1);
            row2.createCell(0).setCellValue("C++");
            row2.createCell(1).setCellValue("12");
            row2.createCell(2).setCellValue("Automation");
        XSSFRow row3 = sheet.createRow(2);
            row3.createCell(0).setCellValue("Python");
            row3.createCell(1).setCellValue("3");
            row3.createCell(2).setCellValue("Automation");
        workbook.write(fileOutput);
        workbook.close();
        fileOutput.close();
        System.out.println("File is created successfully !");
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(list);

    }

    @Test
    public void displayConfigfile(){
        ReadConfigFile readConfigFile = new ReadConfigFile();
        System.out.println(readConfigFile.getUrl("appURL"));
        System.out.println(readConfigFile.email("email"));
        System.out.println(readConfigFile.password("password"));
        System.out.println(readConfigFile.productName("searchProductName"));

    }

}
