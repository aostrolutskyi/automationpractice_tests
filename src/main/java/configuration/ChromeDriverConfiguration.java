package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ChromeDriverConfiguration {

    public static void setWait(WebDriver driver, long seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public static void setDriverPath(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
    }

    public static ChromeOptions setDriverOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("chrome.switches", Arrays.asList("--incognito"));
        options.addArguments("test-type");
        return options;
    }
}
