package dataProviders;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviders {

    @BeforeClass
    public void setUp(){
        System.out.println("Starting test");
    }

    @Test(dataProvider = "testData")
    public void display(String s1,String s2){
        System.out.println(s1+" "+s2);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Closing test");
    }


    @DataProvider
    public Object[][] testData(){
        Object[][] data = {{"amit","123"},{"jogn","345"},{"david","0994"}};
        return data;

    }

}
