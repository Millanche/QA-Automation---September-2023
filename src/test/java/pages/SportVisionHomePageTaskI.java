package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;


public class SportVisionHomePageTaskI extends BaseHelper {
    WebDriver driver;

    public SportVisionHomePageTaskI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cookie-agree-gdpr")
    WebElement acceptCookiesButton;

    private void navigateToPage() {
        driver.get("https://www.sportvision.ba/");
    }
    private void clickYesOnCookiesButton() throws InterruptedException {
        wdWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
        Thread.sleep(5000);
    }

    private void inNavigationBarSelectWoman() throws InterruptedException {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.navtext[title='Žene']")));
        WebElement woman = driver.findElement(By.cssSelector("a.navtext[title='Žene']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(woman).build().perform();
        Thread.sleep(5000);
    }
    private void selectSneakersInDropdownMenu() throws InterruptedException {
        WebElement sneakers = driver.findElement(By.cssSelector("a[href='https://www.sportvision.ba/obuca/za-zene+unisex/za-odrasle/']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(sneakers).perform();
        Thread.sleep(5000);

    }
    private void selectWishedAirMax() throws InterruptedException {
        WebElement airMax = driver.findElement(By.cssSelector("a[href = 'https://www.sportvision.ba/obuca/za-zene+unisex/za-odrasle/?search=nike%20air%20max']"));
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href = 'https://www.sportvision.ba/obuca/za-zene+unisex/za-odrasle/?search=nike%20air%20max']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(airMax).perform();
        airMax.click();
        Thread.sleep(3000);

    }
    public void searchForArticles() throws InterruptedException{
        navigateToPage();
        clickYesOnCookiesButton();
        inNavigationBarSelectWoman();
        selectSneakersInDropdownMenu();
        selectWishedAirMax();

    }

}


