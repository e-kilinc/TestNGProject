package techproed.tests.day24Priority_DependsOnMethods_Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C07_SoftAssert {
    //    Yeni bir Class Olusturun : C03_SoftAssert
//1. "http://zero.webappsecurity.com/" Adresine gidin
// 2. Sign in butonuna basin
//3. Login kutusuna "username" yazin
//4. Password kutusuna "password" yazin
//5. Sign in tusuna basin
//6. Online banking menusu icinde Pay Bills sayfasina gidin
//7. "Purchase Foreign Currency" tusuna basin
//8. "Currency" drop down menusunden Eurozone'u secin
//9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
//10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//(dollar)","Thailand (baht)"
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void softAssert() throws InterruptedException {
 //1. "http://zero.webappsecurity.com/" Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

// 2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

//3. Login kutusuna "username" yazin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

//4. Password kutusuna "password" yazin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
//5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        driver.navigate().back();
        Thread.sleep(3000);

//6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

//7. "Purchase Foreign Currency" tusuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

//8. "Currency" drop down menusunden Eurozone'u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByIndex(6);

//9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(ddm.isSelected());

//10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
//edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
//(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
//(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
//(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
//(dollar)","Thailand (baht)"
        List<WebElement> currencies = select.getOptions();
        List<WebElement> elementler = select.getOptions();
        for (WebElement each:elementler) {
            System.out.println(each.getText());
        }
        // elementler.stream().forEach(t-> System.out.println(t.getText()));
        softAssert.assertEquals(elementler,"Select One\n" +
                "Australia (dollar)\n" +
                "Canada (dollar)\n" +
                "Switzerland (franc)\n" +
                "China (yuan)\n" +
                "Denmark (krone)\n" +
                "Eurozone (euro)\n" +
                "Great Britain (pound)\n" +
                "Hong Kong (dollar)\n" +
                "Japan (yen)\n" +
                "Mexico (peso)\n" +
                "Norway (krone)\n" +
                "New Zealand (dollar)\n" +
                "Sweden (krona)\n" +
                "Singapore (dollar)\n" +
                "Thailand (baht)");
        Thread.sleep(1000);
        softAssert.assertAll();

    }
}
