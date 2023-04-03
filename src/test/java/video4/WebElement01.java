package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebElement01 {
    /*
    1-https://www.amazon.com sayfasina gidin
    2-arama cubuguna "nutella" yazin
    3-Nutella yazdiktan sonra Enter'a basin arama istegini yapin
    4-Bulunan sonuc sayisini yazdirin
     */
    public static void main(String[] args) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Ilk kisim webDriverin yuklenmesini sagliyor daha onceden pom de
        //olusturdugumuz verileri buraya atiyoruz

        //1-https://www.amazon.com sayfasina gidin
        driver.get("https://www.amazon.com");
        //2-arama cubuguna "nutella" yazin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella");
        //3-Nutella yazdiktan sonra Enter'a basin arama istegini yapin
        searchBox.submit();
        //4-Bulunan sonuc sayisini yazdirin
        WebElement sonucYaziElementing = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYaziElementing.getText());
        driver.close();







    }

}
