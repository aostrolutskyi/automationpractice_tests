package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    public PageHeader header;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        this.header = new PageHeader(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailAddressField;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id='SubmitLogin']")
    public WebElement submitLoginButton;
}
