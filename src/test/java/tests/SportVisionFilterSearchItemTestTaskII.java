package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import pages.SportVisionHomePageTaskII;
import pages.SportVisionApplyFilterTaskII;

public class SportVisionFilterSearchItemTestTaskII extends BaseTest {

    @Test
    public void checkFilteredResults() throws InterruptedException {

        String searchItem = "duks";

        SportVisionHomePageTaskII sportVisionHomePageII = new SportVisionHomePageTaskII(driver);
        sportVisionHomePageII.searchForArticlesII(searchItem);

        SportVisionApplyFilterTaskII sportVisionApplyFilterTaskII = new SportVisionApplyFilterTaskII(driver);
        sportVisionApplyFilterTaskII.justDoThat();

        WebElement articlesContainer = driver.findElement(By.cssSelector(".block.products-listing.product.product-listing-items.product-colors"));
        List<WebElement> articles = articlesContainer.findElements((By.cssSelector("[data-productcat]")));
        System.out.println("Size of List: " + articles.size());

        for (WebElement article : articles) {
            WebElement articleTitle = article.findElement(By.partialLinkText("a"));
            String title = articleTitle.getText();

            softAssertion.assertTrue(title.toUpperCase().contains(searchItem.toUpperCase()), "Article: \n" + title + "\n does NOT contain Search Term in the tittle!");

        }

        softAssertion.assertAll();


    }
}

