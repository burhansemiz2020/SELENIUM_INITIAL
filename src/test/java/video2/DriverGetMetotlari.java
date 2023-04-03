package video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverGetMetotlari {
    public static void main(String[] args) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);

        // 1. METOT: driver.get("url")==> yazarsak url ye gider
        driver.get("https://www.amazon.com");

        // 2. METOT: driver.getTitle ==> icinde oldugu sayfanin basligini dondurur
        System.out.println("page title : " + driver.getTitle());//page title : Amazon.com. Spend less. Smile more.

        //3. METOT: driver.getCurrentUrl() ==> icinde oldugu sayfanin url sini dondurur.
        System.out.println("Current url : " + driver.getCurrentUrl());//https://www.amazon.com/

        //4. METOT: driver.getPageSource() ==> icinde oldugu sayfanin kaynak kodlarini dondurur.
        System.out.println("=============================================");
        System.out.println("Page source : " + driver.getPageSource());//
        System.out.println("=============================================");

        //5. METOT: driver.getWindowHandle() ==> icinde oldugu sayfanin Unique hash kodunu dondurur.
        System.out.println("Hash code of page: " +driver.getWindowHandle());

        //6. METOT: driver.getWindowHandles() ==> driver calisirken acilan tum sayfalarin Unique hash kodunu dondurur.
        System.out.println("Hash codes of all pages: " + driver.getWindowHandles());




    }
}
