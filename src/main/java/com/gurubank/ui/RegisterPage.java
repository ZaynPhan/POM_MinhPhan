package com.gurubank.ui;

import common.BaseElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseElement {
    @FindBy(xpath = "//input[@name='emailid']")
    WebElement txtEmailSignUp;

    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement btnSubmit;

    @FindBy(xpath = "//td[text()='User ID :']/following-sibling::td")
    WebElement lbUserID;

    @FindBy(xpath = "//td[text()='Password :']/following-sibling::td")
    WebElement lbPassword;

    public void inputEmail(String email){
        waitForElementVisible(txtEmailSignUp);
        inputElement(txtEmailSignUp,email);
    }

    public void clickSubmit(){
        waitForElementVisible(btnSubmit);
        clickToElement(btnSubmit);
    }

    public String getUserID(){
        waitForElementVisible(lbUserID);
        return getTextElement(lbUserID);
    }

    public String getPassword(){
        waitForElementVisible(lbPassword);
        return getTextElement(lbPassword);
    }


}
