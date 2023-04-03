package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverNavigateMetotlari {
    public static void main(String[] args) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        /*
        DriverNavigate metodu farkli sayfalar arasinda gecis yapmayi saglayan
        bir metottur.
         */
        //1. METOT: driver.navigate().to metodu ile gittigimiz sayfadan sonra farkli bir sayfaya gidebiliyoruz.
        driver.get("https://www.amazon.com");//get sadece siteye gitme islemini yapar.
        driver.navigate().to("https://www.facebook.com");
        //2-driver.navigate().back(); ==> bir onceki sayfaya donus yapar
        driver.navigate().back();//amazona geri donus yapiyor.
        //3-driver.navigate().forward; ==> Bir ileri sekmeye gitmek icin
        driver.navigate().forward();//facebooka donuyor
        //4-driver.navigate().refresh; ==> icinde oldugu sayfayi yeniler
        driver.navigate().refresh();
        //5-driver.close();==> bulundugumuz sayfayi kapatiriz.
        //5-driver.quit();==> quit ise eger calisirken birden fazla window varsa hepsini kapatir.
        driver.close();
        driver.quit();
    }
}
