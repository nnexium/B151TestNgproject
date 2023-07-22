package techproed.tests.day24_Priority_DependsOnMethods_Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
    /*
    Junitte test methodlarını istediğimiz şekilde sıralamak için method isimlerini alfabetik ve numerik sıralı
    olarak yazmamız gerekiyordu.TestNG frameworkunde bu sıralama için @Test notasyonundan sonra parametre olarak
    priority=1 gibi öncelik sırası belirterek test methodlarımızı sıralayabiliriz.
    Priorty kullanmadığımız methodda priority değerini 0 olarak kabul eder.
     */
    WebDriver driver;

    @BeforeMethod
    public void setUup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(priority = 1)
    public void amazonTest() {
        driver.get("https://www.amazon.com");//--> ikinci olarak amazon çalışsın
    }

    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");//--> youtube önce çalışsın
    }
    @Test(priority = 2)
    public void facebookTest() {
        driver.get("https://facebook.com");//--> son olarak facebook çalşısın
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

