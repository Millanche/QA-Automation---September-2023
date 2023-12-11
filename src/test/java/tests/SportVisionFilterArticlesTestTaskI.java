package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import pages.SportVisionHomePageTaskI;
import pages.SportVisionApplyFilterTaskI;

public class SportVisionFilterArticlesTestTaskI extends BaseTest {

    @Test
    public void checkFilteredResult() throws InterruptedException {

        String searchItem = "Nike Air Max";
        SportVisionHomePageTaskI sportVisionHomePage = new SportVisionHomePageTaskI(driver);
        sportVisionHomePage.searchForArticles();

        SportVisionApplyFilterTaskI sportVisionApplyFilter = new SportVisionApplyFilterTaskI(driver);
        sportVisionApplyFilter.selectAscendingPrice();

        WebElement articlesContainer = driver.findElement(By.cssSelector(".block.products-listing.product.product-listing-items.product-colors"));

        List<WebElement> pricesListRaw = articlesContainer.findElements(By.cssSelector(".current-price.price-with-discount"));
        List<WebElement> articles = articlesContainer.findElements(By.className("title"));
        List<Double> priceListFixed = new ArrayList<>();

        for (WebElement textPrice : pricesListRaw) {
            String priceText = textPrice.getText();
            String priceTextFixed = priceText.replace("BAM", "").replace(".", "").replace(",", ".");

            double priceDouble = Double.parseDouble(priceTextFixed);

            priceListFixed.add(priceDouble);
        }
            System.out.println("Size of priceListFixed: " + priceListFixed.size());

            for (double a : priceListFixed) {
                System.out.print( a + " ");
            }


            for (int i = 0; i < priceListFixed.size() - 1; i++) {
                double startPrice = priceListFixed.get(i);
                double nextPrice = priceListFixed.get(i + 1);
                softAssertion.assertTrue(startPrice <= nextPrice, "Articles are not sorted in ascending order! \nCurrent price: " + startPrice + "\nbut Next price is: " + nextPrice);
            }

            for (WebElement article : articles) {
                String title = article.getText();
                System.out.println(title);
                softAssertion.assertTrue(title.toUpperCase().contains(searchItem.toUpperCase()), "Article: \n" + title + "\n does NOT contain Search Term in the tittle!");
            }

            softAssertion.assertAll();
                }
            }









