package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePageClass;
import techproed.utulities.ConfigReader;
import techproed.utulities.Driver;

public class C02_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //Username : Admin
        //Password : admin123

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePageClass.username().sendKeys(ConfigReader.getProperty("openSourceUsername"));
        OpenSourcePageClass.password().sendKeys(ConfigReader.getProperty("openSourcePassword"));
        OpenSourcePageClass.submitButton().click();


        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(OpenSourcePageClass.verify().isDisplayed());

        //Sayfayi kapatiniz
        Driver.closeDriver();
    }
}
