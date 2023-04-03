package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.edgedriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUser")).sendKeys("example@nnthink.com");
    }
}
