package com.gurubank;

import common.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseElement {
    @FindBy(xpath = "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")
    WebElement lbWelcomeGreeting;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTextWelcomeGreeting(){
        waitForElementVisible(lbWelcomeGreeting);
        return getTextElement(lbWelcomeGreeting);
    }
}
