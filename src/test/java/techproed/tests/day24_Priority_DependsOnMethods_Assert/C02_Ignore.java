package techproed.tests.day24_Priority_DependsOnMethods_Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;

    @BeforeMethod
    public void setUup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    //Birden fazla test methodu çalıştırmak istediğimizde o anlık gereksiz gördüğümüz test methodunu
    //atlamak (ignore) isteyebiliriz.Bunun için  @Test notasyonu üstüne yada yanına @Ignore notasyonu
    //eklememiz yeterlidir.
    //Eğer bir methodu tamamen iptal etmek isterseniz @Test notasyonundan sonra parametre olarak
    //enable=false kullanabiliriz.
    @Ignore
    @Test(priority = 1)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test(enabled = false)//
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test(priority = 2)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
