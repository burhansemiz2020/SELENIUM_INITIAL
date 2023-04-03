package video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_JUnitAssertion {
    @Test
    public void test01() {
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
        //4. Click on 'Signup / Login' button
        WebElement signUpLinki=driver.findElement(By.xpath("//a[text()=' Signup / Login'] "));
        signUpLinki.click();
        //5. Verify 'Login to your account' is visible
        WebElement loginYaziElementi=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());
        //6. Enter correct email address and password
        WebElement emailAdresKutusu=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdresKutusu.sendKeys("ahmet@nehaber.com");
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordKutusu.sendKeys("12345");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();//sadece click islemi
        // varsa locate icin object olusturmaya gerek yok yani WebElement kismina gerek yok

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInYazisi=driver.findElement(By.xpath("//a[text()=' Logged in as '] "));
        Assert.assertTrue(loggedInYazisi.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();
        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //11. Close driver
        driver.close();

        
    }
    
    



    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page
    //11. Close driver










}
