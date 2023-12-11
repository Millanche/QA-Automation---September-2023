package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SportVisionApplyFilterTaskI extends BaseHelper {
    WebDriver driver;

    public SportVisionApplyFilterTaskI(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sort")
    WebElement dropdownSortField;

    public void selectAscendingPrice() throws InterruptedException {
        dropdownSortField.click();
        Thread.sleep(2000);
        Select price = new Select(dropdownSortField);
        price.selectByValue("justPriceAsc");
        Thread.sleep(10000);


    }

}