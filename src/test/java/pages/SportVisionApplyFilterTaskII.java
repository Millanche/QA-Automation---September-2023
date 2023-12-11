package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SportVisionApplyFilterTaskII extends BaseHelper {
    WebDriver driver;

    public SportVisionApplyFilterTaskII(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nb_f-attr-25486799")
    WebElement searchCategory;
    @FindBy(id = "sort")
    WebElement dropdownSortField;


    private void genderSelect() throws InterruptedException {
        WebElement leftSideBarContainer = driver.findElement(By.id("nb_f-attr-25486799"));
        WebElement genderSelectButton = leftSideBarContainer.findElement(By.className("title"));
        genderSelectButton.click();
        Thread.sleep(2000);
    }

    private void selectKids() throws InterruptedException {
        wdWait.until(ExpectedConditions.visibilityOf(searchCategory));
        List<WebElement> categoryList = searchCategory.findElements(By.tagName("li"));
        if (!categoryList.isEmpty()) {
            WebElement kidsCheckBox = categoryList.get(categoryList.size() - 1);
            kidsCheckBox.click();
        }
        Thread.sleep(2000);
    }

    private void selectLastAddedItems() throws InterruptedException {
        dropdownSortField.click();
        Thread.sleep(2000);
        Select price = new Select(dropdownSortField);
        price.selectByValue("new");
        Thread.sleep(2000);
    }
    private void closeGenderField() throws InterruptedException {
        WebElement leftSideBarContainer = driver.findElement(By.id("nb_f-attr-25486799"));
        WebElement genderSelectButton = leftSideBarContainer.findElement(By.className("title"));
        genderSelectButton.click();
        Thread.sleep(2000);
    }

    public void justDoThat () throws InterruptedException {
            genderSelect();
            selectKids();
            selectLastAddedItems();
            closeGenderField();

        }

    }

