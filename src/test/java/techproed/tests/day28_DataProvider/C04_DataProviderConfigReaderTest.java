package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProviderConfigReaderTest {
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{ConfigReader.getProperty("mail1"), ConfigReader.getProperty("sifre1")},
                {ConfigReader.getProperty("mail2"), ConfigReader.getProperty("sifre2")},
                {ConfigReader.getProperty("mail3"), ConfigReader.getProperty("sifre3")},
                {ConfigReader.getProperty("mail4"), ConfigReader.getProperty("sifre4")}};
    }
            /*
        Dataprovider kullanarak .properties dosyasındaki verilerile BlueRentalCar sitesine login olalım
         */

    @Test(dataProvider = "blueRental")
    public void test01(String mail, String password) {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.bekle(2);
        blueRentalPage.email.sendKeys(mail,Keys.TAB, password, Keys.ENTER);
        Driver.closeDriver();

    }
}
