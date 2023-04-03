package video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebElement02 {
    // https://www.facebook.com adresine gidin
    // cookies cikarsa kabul et butonuna basin
    // e-posta kutusuna rastgele bir mail girin
    // sifre kismina rastgele bir sifre girin
    // giris yap butonuna basin
    // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
    //  mesajinin ciktigini test edin
    public static void main(String[] args) {
        //0. Chromedriver burada yuklenecek
        ChromeOptions ops= new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //2- cookies cikarsa kabul et butonuna basin
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
        // e-posta kutusuna rastgele bir mail girin
        WebElement epostaKutusu=driver.findElement(By.xpath("//input[@id='email']"));
        epostaKutusu.sendKeys("askjdbhiajdL");
        // sifre kismina rastgele bir sifre girin
        WebElement sifre=driver.findElement(By.xpath("//input[@id='pass']"));
        sifre.sendKeys("asdasd");
        // giris yap butonuna basin

        driver.findElement(By.xpath("//button[@name='login']")).click();
        // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
        //  mesajinin ciktigini test edin
        //sayfayi kapatin
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedSonuc="The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        String actualSonucYazisi=sonucYazisiElementi.getText();
        if (actualSonucYazisi.equals(expectedSonuc)) {
            System.out.println("Girilemedi Testi passed");
        }else{
            System.out.println("Girilemedi Testi failed");
        }
        driver.close();



    }



}
