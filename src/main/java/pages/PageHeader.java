package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHeader {

    private WebDriver driver;

    public PageHeader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#header_logo > a > img")
    public WebElement logoImage;

    @FindBy (xpath = "//*[@id='search_query_top']")
    public WebElement searchField;

    @FindBy (xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
    public WebElement cartLink;

    @FindBy (css = "#category > div.ac_results")
    public WebElement searchList;

}
