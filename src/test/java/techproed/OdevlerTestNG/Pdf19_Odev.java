package techproed.OdevlerTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Pdf19_Odev {


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

//        1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

//        2. Sign in butonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

//        3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("(//*[@id='user_login'])[1]")).sendKeys("username");

//        4. Password kutusuna “password” yazin
        driver.findElement(By.xpath("(//*[@id='user_password'])[1]")).sendKeys("password");

//        5. Sign in tusuna basin
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().back();

//        6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[@id='onlineBankingMenu'])[1]")).click();
        driver.findElement(By.xpath("(//*[@id='pay_bills_link'])[1]")).click();

//        7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[text()='Purchase Foreign Currency'])")).click();

//        8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddmSelectaState = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddmSelectaState);
        select.selectByVisibleText("Eurozone (euro)");
//        9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ddmSelectaState.getText().contains("Eurozone (euro)"));

//        10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//        edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//        (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//        (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//                (krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//                (dollar)","Thailand (baht)"
        List<WebElement> tumOptionlar = new ArrayList<>();

        for (WebElement each : tumOptionlar) {
            System.out.println(each.getText());

            List<String> expectedList = List.of("Select One", "Australia (dollar)",
                    "Canada (dollar)","Switzerland(franc)","China (yuan)","Denmark (krone)",
                    "Eurozone (euro)","Great Britain(pound)","Hong Kong (dollar)","Japan (yen)",
                    "Mexico (peso)","Norway(krone)","New Zealand (dollar)","Sweden (krona)",
                    "Singapore(dollar)","Thailand (baht)");
        softAssert.assertEquals(expectedList, tumOptionlar);
        softAssert.assertAll();

//            List<String> actualList = new ArrayList<>();
//            select.getOptions().forEach(w->actualList.add(w.getText()));
//            List<String> expectedList = List.of("Select One", "Australia (dollar)",
//                    "Canada (dollar)","Switzerland(franc)","China (yuan)","Denmark (krone)",
//                    "Eurozone (euro)","Great Britain(pound)","Hong Kong (dollar)","Japan (yen)",
//                    "Mexico (peso)","Norway(krone)","New Zealand (dollar)","Sweden (krona)",
//                    "Singapore(dollar)","Thailand (baht)");
//            softAssert.assertEquals(expectedList, actualList);
        }




    }
}
