package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {
    @Test
    public void test01() {
        /*
        test yaptığımız sayfadaki dataları properties yada excel dosyasından alabiliriz.
        properties dosyasından verileri okuyabilmemiz için ConfigReader class'ı oluşturmuştuk, Aynı şekilde
        excel dosyasındaki veriler okuyabilmek için ExcelReader class'ı oluşturduk.Buradan alacağımız email ve
        password bilgilerini String bir değişkene assing edip login testi yapacağımız sitede sendKeys() methodu ile
        çok rahat kullalnabiliriz

         */

        ExcelReader reader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email = reader.getCellData(1,0);
        String password = reader.getCellData(1,1);

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //mysmoketestdata excel dosyasından bir kullanıcı ile login olalım
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER );
        ReusableMethods.bekle(3);

        //Login olduğumuzu doğrulayalım
        Assert.assertTrue(rentalPage.loginVerify.getText().contains("Sam"));
        /*
        Login webelementi login olduktan sonrada aynı locate sahip olabilme ihtimaline karşı daha garanti
        bir doğrulama yapmak için login olduktan sonra login webelementinin olduğu
        yerde login olduğumuz kullanıcı ismi çıkacaktır. Bu webelementin yazısını getText() methodu ile
        alıp kullanıcı ismini içeriyor mu içermiyor mu olarak test ederiz.
         */

        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}
