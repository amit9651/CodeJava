package problems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium {
    static  WebDriver driver;
    public static void main(String[] args) {
        WebDriver driver;
        openPage();
    }

    public static void openPage(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement createAccount = driver.findElement(By.xpath("//a[text() = 'Create new account']"));
        wait.until(ExpectedConditions.visibilityOf(createAccount)).click();
        WebElement facebookLogo = driver.findElement(By.xpath("//span[text()='Get started on Facebook']"));
        boolean logoVisible = wait.until(ExpectedConditions.visibilityOf(facebookLogo)).isDisplayed();
        System.out.println("Facebook logo is visible: "+logoVisible);
        driver.close();
    }
}
