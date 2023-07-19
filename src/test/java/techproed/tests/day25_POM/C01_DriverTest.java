package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utulities.Driver;

public class C01_DriverTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://www.facebook.com");

        /*
        Driver'a koyduğumuz if bloğu ile burdaki sayfalara tekm browser ile sırasıyla gittik
        Driver daki if bloğunu kullanmadığımız zaman her get() methodu kullandığımızda yeni bir browser açtı
         */

    }

    @Test
    public void test03() {
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.youtube.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.facebook.com");
    }

    @Test
    public void test04() {
        //Driver driver = new Driver();
        //Singleton pattern kullandığımız için obje oluşturmanın önüne geçtik
    }
}
