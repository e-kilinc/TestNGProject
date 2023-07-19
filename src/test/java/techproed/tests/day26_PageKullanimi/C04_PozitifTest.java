package techproed.tests.day26_PageKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utulities.ConfigReader;
import techproed.utulities.Driver;
import techproed.utulities.ReusableMethods;

public class C04_PozitifTest {
    @Test
    public void test01() {
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);

        //Admin email: jack@gmail.com
        //Admin password: 12345
        rentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalemail"), Keys.TAB,
                ConfigReader.getProperty("blueRentalpassword"), Keys.ENTER);

        //Giris yapildigini dogrulayin
        ReusableMethods.bekle(2);
        Assert.assertTrue(rentalPage.loginVerify.getText().contains("Jack"));

        //Sayfayi kapatiniz
        Driver.closeDriver();
    }
}
