package video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_Junit_Assertion {
    @Test
    public void test02() throws InterruptedException {
        //1. Launch browser
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logoElementi= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products'] ")).click();
        driver.get("https://automationexercise.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Close");

        //5. Verify user is navigated to ALL PRODUCTS page successfully
       String expectedUrl="https://automationexercise.com/products";
       String actualUrl= driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);
       //6. Enter product name in search input and click search button
       WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search_product']"));
       aramaKutusu.sendKeys("tshirt");
       driver.findElement(By.xpath("//button[@id='submit_search']")).click();
       //7. Verify 'SEARCHED PRODUCTS' is visible
       WebElement aramaYapildiElementi= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
       Assert.assertTrue(aramaYapildiElementi.isDisplayed());
       //8. close driver
       driver.close();





    }
    /*






    7. Verify search products is visible
    8. close driver
     */

}
