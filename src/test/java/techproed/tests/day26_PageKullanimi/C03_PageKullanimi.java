package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.utulities.ConfigReader;
import techproed.utulities.Driver;
import techproed.utulities.ReusableMethods;

public class C03_PageKullanimi {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage centerPage = new TestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        centerPage.submit.click();
        ReusableMethods.bekle(2);//-->Method ile bekledik
        Assert.assertTrue(centerPage.loginVerify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logout.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(centerPage.submit.isDisplayed());

        //Sayfayi kapatiniz
        Driver.closeDriver();

    }
}
