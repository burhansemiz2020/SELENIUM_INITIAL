package video5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Before_After_Notasyonlari {
    WebDriver driver;
    @Before
    public void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test01() {
        driver.get("https:www.amazon.com");
    }
    @Test
    public void test02() {

        driver.get("https:www.bestbuy.com");
    }
    @Test
    public void test03() {

        driver.get("https:www.facebook.com");
    }

}
