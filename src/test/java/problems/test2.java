package problems;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test() throws InterruptedException {

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
}
