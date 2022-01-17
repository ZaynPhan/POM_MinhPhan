package com.gurubank.scripts;

import com.beust.jcommander.Parameter;
import com.gurubank.HomePage;
import com.gurubank.LoginPage;
import com.gurubank.RegisterPage;
import common.BaseElement;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    RegisterPage registerPage;
    HomePage homePage;

    @Parameters({"browser", "urlRegister"})
    @BeforeClass
    public void beforeClass(String browser, String urlRegister){
       driver = launchBrowser(browser, urlRegister);
    }

    @Parameters( "urlLogin")
    @Test
    public void TC01_LoginSuccessfully(String urlLogin){

        registerPage = PageFactory.initElements(driver,RegisterPage.class);
        registerPage.inputEmail("minh" + randomNumber() +"@gmail.com");
        registerPage.clickSubmit();

        String userName = registerPage.getUserID();
        String password = registerPage.getPassword();

        loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.openUrl(urlLogin);
        loginPage.inputUserID(userName);
        loginPage.inputPassword(password);
        loginPage.clickLogin();

        homePage = PageFactory.initElements(driver,HomePage.class);
        String welcomeGreetingMessage = homePage.getTextWelcomeGreeting();
        verifyEqual(welcomeGreetingMessage, "Welcome To Manager's Page of Guru99 Bank");
    }

    @AfterClass
    public void afterClass(){
        quitBrowser();
    }
}
