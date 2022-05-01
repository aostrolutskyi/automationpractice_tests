package configuration;

public class FirefoxDriverConfiguration {

    public static void setDriverPath(){
        System.setProperty("webdriver.gecko.driver","geckodriver");
    }
}
