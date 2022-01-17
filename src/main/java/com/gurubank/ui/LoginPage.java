package com.gurubank.ui;

import common.BaseElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseElement {
    @FindBy(xpath = "//a[text()='here']")
    WebElement lbHere;

    @FindBy(xpath = "//input[@name='uid']")
    WebElement txtUserID;

    @FindBy(xpath = "//input[@name='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement btnLogin;

    public void clickHere(){
        waitForElementVisible(lbHere);
        clickToElement(lbHere);
    }

    public void inputUserID(String userID){
        waitForElementVisible(txtUserID);
        inputElement(txtUserID, userID);
    }

    public void inputPassword(String password){
        waitForElementVisible(txtPassword);
        inputElement(txtPassword, password);
    }

    public void clickLogin(){
        waitForElementVisible(btnLogin);
        clickToElement(btnLogin);
    }
}
