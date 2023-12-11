package pages;
import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SVOperateWithCartTaskIII extends BaseHelper {
    WebDriver driver;

    public SVOperateWithCartTaskIII(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeNumberOfItems() throws InterruptedException {
        WebElement selectContainer = driver.findElement(By.id("order_cart_content"));
        WebElement selectNumberOfItems = selectContainer.findElement(By.id("quantity_1"));
        Select quantity = new Select(selectNumberOfItems);
        quantity.selectByValue("2");
        Thread.sleep(3000);
    }

}










