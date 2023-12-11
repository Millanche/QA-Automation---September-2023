package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SportVisionAddToCartTaskIII extends BaseHelper {
    WebDriver driver;

    public SportVisionAddToCartTaskIII(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-product-item-id='KAE213U013-36']")
    WebElement selectedItem;
    @FindBy(id = "nb_addToCartButton")
    WebElement addToCartButton;
    @FindBy(id = "miniCartContent")
    WebElement cartButton;
    @FindBy(css = "a[href='https://www.sportvision.ba/kupovina']")
    WebElement myCartButton;
    @FindBy(className = "list-title")
    WebElement infoModal;




    private void selectItem() throws InterruptedException{
        wdWait.until(ExpectedConditions.visibilityOf(selectedItem));
        selectedItem.click();
        Thread.sleep(4000);
    }
    private void addItemToCart() throws InterruptedException{

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int scrollPercentage = 15;
        long windowHeight = (Long) js.executeScript("return window.innerHeight;");
        long documentHeight = (Long) js.executeScript("return Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
        long scrollDistance = (documentHeight - windowHeight) * scrollPercentage / 100;
        js.executeScript("window.scrollBy(0, arguments[0])", scrollDistance);
        wdWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        Thread.sleep(5000);
    }
    private void openCartPreview() throws InterruptedException{
        wdWait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
        Thread.sleep(2000);
    }
    private void openMyCart() throws InterruptedException{
        wdWait.until(ExpectedConditions.elementToBeClickable(myCartButton));
        myCartButton.click();
        Thread.sleep(2000);
    }
    public void addingToCart() throws InterruptedException{
        selectItem();
        addItemToCart();
        openCartPreview();
        openMyCart();
        Thread.sleep(3000);
    }

}