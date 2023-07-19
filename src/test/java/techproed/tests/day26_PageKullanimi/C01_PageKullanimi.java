package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utulities.ConfigReader;
import techproed.utulities.Driver;

public class C01_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //Username : Admin
        //Password : admin123

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePage sourcePage = new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("openSourceUsername"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        sourcePage.submitbutton.click();


        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(sourcePage.verify.isDisplayed());

        //sayfayı kapatınız
        Driver.closeDriver();

    }
}
