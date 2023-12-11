package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SportVisionHomePageTaskII extends BaseHelper {
    WebDriver driver;

    public SportVisionHomePageTaskII(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cookie-agree-gdpr")
    WebElement acceptCookiesButton;
    @FindBy(css = "[title='Pretraži sajt']")
    WebElement searchSiteButton;
    @FindBy(id = "search-text")
    WebElement inputSearchField;
    @FindBy(css = "[title='Prikaži sve rezultate']")
    WebElement showResultsButton;


    private void navigateToPage() {
        driver.get("https://www.sportvision.ba/");
    }

    private void clickYesOnCookiesButton() throws InterruptedException {
        wdWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
        Thread.sleep(5000);
    }

    private void openSearchField() throws InterruptedException {
        searchSiteButton.click();
        Thread.sleep(2000);
    }

    private void inputSearchTerm(String searchItem) throws InterruptedException {
        inputSearchField.sendKeys(searchItem);
        Thread.sleep(3000);
    }

    private void clickOnShowResultsButton() throws InterruptedException {
        showResultsButton.click();
        Thread.sleep(2000);

    }

    public void searchForArticlesII(String searchItem) throws InterruptedException {
        navigateToPage();
        clickYesOnCookiesButton();
        openSearchField();
        inputSearchTerm(searchItem);
        clickOnShowResultsButton();
        Thread.sleep(2000);

    }
}


