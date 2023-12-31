package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utulities.Driver;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//*[@role='button'])[1]")
    public WebElement login;

    @FindBy(xpath="//*[@name='email']")
    public WebElement email;

    @FindBy(xpath="(//*[@type=\"button\"])[1]")
    public WebElement loginVerify;
}
