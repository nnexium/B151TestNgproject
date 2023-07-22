package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public static Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","İcAnadolu","06"},
                {"Izmir","Ege","35"},
                {"Adana","Akdeniz","01"}};
    }
}
