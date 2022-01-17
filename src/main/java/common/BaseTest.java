package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BaseTest {
    WebDriver driver;

    public WebDriver launchBrowser(String browser, String url){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        } else if(browser.equals("firefox")){
        }
        return driver;
    }

    public void verifyEqual(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    public void verifyTrue(Boolean condition){
        Assert.assertTrue(condition);
    }

    public void verifyFalse(Boolean condition){
        Assert.assertFalse(condition);
    }

    public int randomNumber() {
        return (int) (Math.random() * 1000000 + 1);
    }

    public void quitBrowser(){
        driver.quit();
    }
}
