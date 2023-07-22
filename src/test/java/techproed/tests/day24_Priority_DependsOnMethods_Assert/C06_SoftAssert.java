package techproed.tests.day24_Priority_DependsOnMethods_Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {
    /*
        SoftAssert kullanımında junitteki daha önce kullandığımız methodların aynısını kullanırız,
    daha önceden kullandığımız assertion nerde hata alırsa orada testlerin çalışmasını durdurur,
    SoftAssert'te ne kadar assertion kullansakta nerde assertAll() methodu kullanırsak testlerimiz de
    kullandığımız assertionlar orda sonlanır ve hata varsa bunu bize konsolad belirtir.
     */
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//--> SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturduk
        softAssert.assertEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacağız

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("Best"));//Buradada bilerek hata alacağız

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("İphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonuYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonuYazisi.getText().contains("samsung"));//bilerek hata alacağız
        softAssert.assertAll();
        System.out.println("Burası çalışmaz");

    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//--> SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturduk
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://amazon.com.tr");//bilerek hata alacağız

        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("Best"));//Buradada bilerek hata alacağız

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("İphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonuYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertFalse(sonuYazisi.getText().contains("samsung"));//bilerek hata alacağız
        System.out.println("Burası çalışmaz");
        softAssert.assertAll();
    }
}
