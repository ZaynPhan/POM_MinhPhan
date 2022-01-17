package common;
import com.sun.istack.internal.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.ActionChainExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BaseElement {
    protected WebDriver driver;
    private int timeouts = 20;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public String getPageSource(){
        return driver.getPageSource();
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void forwardToPage(){
        driver.navigate().forward();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void clickToElement(WebElement element){
        element.click();
    }

    public String getTextElement(WebElement element){
        return element.getText();
    }
    public void clearElement(WebElement element){
        element.clear();
    }

    public void inputElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void selectCombobox(WebElement element, String value){
        Select combobox = new Select(element);
        combobox.selectByValue(value);
    }

    public String getTextComboboxSelected(WebElement element){
        Select combobox = new Select(element);
        return combobox.getFirstSelectedOption().getText();
    }

    @NotNull
    public String getAtribute(WebElement element, String attribute){
        return element.getAttribute(attribute);
    }

    public int getSizeOfList(List<WebElement> elements){
        return elements.size();
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public boolean isElementSelected (WebElement element){
        return element.isSelected();
    }

    public boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }
    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public String getTextAlert(){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public void inputAlert(String value){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
    }

    public void switchWindowByTitle(String title){
        Set<String> allWindows = driver.getWindowHandles();
        for (String childWindow : allWindows) {
            driver.switchTo().window(childWindow);
            String childTitle = driver.getTitle();
            if (childTitle.equals(title)) {
                break;
            }
        }
    }

    public void switchToIframe(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void hoverMouse(WebElement element){
        Actions hoverMouse = new Actions(driver);
        hoverMouse.moveToElement(element).perform();
    }

    public void doubleClick(WebElement element){
        Actions doubleClick = new Actions(driver);
        doubleClick.doubleClick(element).perform();
    }

    public void rightClick(WebElement element){
        Actions rightClick = new Actions(driver).contextClick(element);
        rightClick.build().perform();
    }

    public void dragAndDrop(WebElement elementFrom, WebElement elementTarget){
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(elementFrom).moveToElement(elementTarget).release(elementTarget).build();
        dragAndDrop.perform();
    }

    public void clickAndHold(List<WebElement> elements, int itemFrom, int itemTarget){
        Actions clickAndHold = new Actions(driver);
        clickAndHold.clickAndHold(elements.get(itemFrom)).clickAndHold(elements.get(itemTarget)).click().perform();
    }

    public void sendKeyPress(WebElement element, Keys key){
        element.sendKeys(key);
    }

    public void uploadBySendKeys(WebElement element, String path){
        element.sendKeys(path);
    }

    public void executeScriptBrowser(String javaScript){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(javaScript);
    }

    public void clickByJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void scrollToBottomPage(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElementPresence(String locator){
        WebDriverWait wait = new WebDriverWait(driver,timeouts);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,timeouts);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForAlertPresence(){
        WebDriverWait wait = new WebDriverWait(driver,timeouts);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
