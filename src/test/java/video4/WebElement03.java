package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class WebElement03 {
    /*
    1. https://www.bestbuy.com adresine gidin
    2. cookies cikarsa kabul et butonuna basin
    3. sayfada kac adet link bulundugunu yazdirin
    4. sayfadaki herbir linkin uzerindeki yazilari yazdirin
     */
    public static void main(String[] args) {
        //0. Chromedriver burada yuklenecek
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://www.bestbuy.com adresine gidin
        driver.get("https://www.bestbuy.com");

        //2. cookies cikarsa kabul et butonuna basin
        //driver.findElement(By.xpath()) cookies has not found

        //3. sayfada kac adet link bulundugunu yazdirin
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());

        //4. sayfadaki herbir linkin uzerindeki yazilari yazdirin
        for (WebElement each : buttonList) {
            System.out.println(each.getText());

        }


    }
}
