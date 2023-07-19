package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utulities.ConfigReader;
import techproed.utulities.Driver;

public class C03_PropertiesKullanimi {

    @Test
    public void amazontest() {
        //amazon sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //basligin amazon icerdigini test edelim
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //arama kutusunda iphone aratalim
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchText"), Keys.ENTER);

        //sayfayi kapatalim
        Driver.closeDriver();

        //google sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //sayfayi kapatalim
        Driver.closeDriver();

        //facebook sayfasina gidiniz
        Driver.getDriver().get("https://www.facebook.com");
    }
}
