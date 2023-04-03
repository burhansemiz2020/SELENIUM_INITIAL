package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManagerMetotlari {
    public static void main(String[] args) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. driver.manage().window() METOTLARI
        //1 A : driver.manage().window().getSize();==> icinde oldugu sayfanin pixel olarak olculerini dondurur.
        System.out.println(driver.manage().window().getSize());//(945, 1020)pixel
        System.out.println(driver.manage().window().getSize().height);//1020

        //1 B : driver.manage().window().getPosition()==>icinde oldugu sayfanin pixel olarak konumunu dondurur
        System.out.println(driver.manage().window().getPosition());//10, 10

        //1 C : driver.manage().window().setPosition(new Point(15,15));==>
        // bunu yazdirdigimizda icinde oldugu sayfanin sol alt kosesini bizim yazdigimiz noktaya getirir
        driver.manage().window().setPosition(new Point(15, 15));
        System.out.println("Yeni pencere olculeri : " + driver.manage().window().getSize());//(945, 1020)

        //1 D : driver.manage().window().setSize(new dimension(900,600)): ==>
        // icinde oldugumuz sayfanin sol alt kosesi sabit olarak bizim yazacagimiz olculere getirir.
        driver.manage().window().setSize(new Dimension(900, 600));
        System.out.println("Yeni pencere konumu : " + driver.manage().window().getPosition());//(15, 15)

        // 1-E driver.manage().window().maximize(); --> icinde oldugu sayfayi maximize yapar
        // 1-F driver.manage().window().fullscreen(); --> icinde oldugu sayfayi fullscreen yapar

        // farklarini gormek icin bu method'lari kullanip, baslangic noktalarini ve boyutlarini yazdiralim
        driver.manage().window().maximize();
        System.out.println("maximize konum : " + driver.manage().window().getPosition()); // (-8, -8)
        System.out.println("maximize boyut : " + driver.manage().window().getSize()); // (1936, 1056)

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : " + driver.manage().window().getPosition()); // (0, 0)
        System.out.println("fullscreen boyut : " + driver.manage().window().getSize()); // (1920, 1080)

        // 1-G driver.manage().window().minimize(); --> sayfayi simge durumunda kucultur
        driver.manage().window().minimize();

        // 2- driver.manage().timeouts() methodlari
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*      wait konusunu ilerde tek basina ele alacagiz
                ancak her class icin yapmamiz gereken bir ayar oldugu icin burada kisaca deginelim
                implicitlyWait : driver'a sayfanin yuklenmesi ve kullanacagimiz webelementlerin bulunmasi icin
                                 bekleyecegi maximum sureyi belirtir.
                                 driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                                 beklemeden calismaya devam eder.
                                 bu sure bittigi halde sayfa yuklenememis/webElement bulunamamissa
                                 exception vererek calismayi durdurur
                Duration.ofSeconds(15) : Duration class'i Selenium-4 ile gelen zaman class'idir
                                         Yani driver'a ne kadar bekleyecegini soyler
                                         Duration.ofSeconds(15) yerine milis,minutes,hours da kullanilabilir
         */

        /* NOT :    Driver'in istedigimiz islemleri yaparken sorunla karsilasmamasi icin
                    driver.manage() method'larindan
                    maximize() ve implicitlyWait() method'larinin her test'te kullanilmasi
                    FAYDALI OLACAKTIR
         */




    }

}
