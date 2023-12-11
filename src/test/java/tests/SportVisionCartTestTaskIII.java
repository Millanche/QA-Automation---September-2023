package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import pages.SportVisionHomePageTaskII;
import pages.SportVisionAddToCartTaskIII;
import pages.SVOperateWithCartTaskIII;

public class SportVisionCartTestTaskIII extends BaseTest {

    @Test
    public void checkCartFunctions() throws InterruptedException {

        String searchItem = "flašica";

        SportVisionHomePageTaskII sportVisionHomePageII = new SportVisionHomePageTaskII(driver);
        sportVisionHomePageII.searchForArticlesII(searchItem);

        SportVisionAddToCartTaskIII sportVisionAddToCartTaskIII = new SportVisionAddToCartTaskIII(driver);
        sportVisionAddToCartTaskIII.addingToCart();

        SVOperateWithCartTaskIII sportVisionOperateWithCartTaskIII = new SVOperateWithCartTaskIII(driver);
        sportVisionOperateWithCartTaskIII.changeNumberOfItems();


        WebElement selectedNumOfItemContainer = driver.findElement(By.id("order_cart_content"));
        WebElement selectedNumberOfItem = selectedNumOfItemContainer.findElement(By.cssSelector("option[selected='selected']"));
        String quantity = selectedNumberOfItem.getAttribute("value");
        System.out.println(quantity);
        WebElement cartNumInfoBadgeContainer = driver.findElement(By.cssSelector("a[href='javascript:void(0)']"));
        WebElement cartNumInfoBadge = cartNumInfoBadgeContainer.findElement(By.xpath("//*[@class='header-carthor-total']"));
        String cartInfoNum = cartNumInfoBadge.getText();
        System.out.println(cartInfoNum);
        Integer selectedQuantity = Integer.parseInt(quantity);



        WebElement priceContainer = driver.findElement(By.cssSelector("tr.item"));
        WebElement singlePriceContFinal = priceContainer.findElement(By.cssSelector(".text-center.cart-price"));
        WebElement singleItemPrice = singlePriceContFinal.findElement(By.xpath("//*[@class='cart-col-inner-wrapper']"));
        String price = singleItemPrice.getText();
        String priceTextFixed = price.replace("BAM", "").replace(".", "").replace(",", ".");
        double itemPriceDouble = Double.parseDouble(priceTextFixed);


        WebElement discountContainer = priceContainer.findElement(By.cssSelector(".text-center.cart-discount"));
        String discount = discountContainer.getText();
        String discountTextFixed = discount.replace("%", "").replace(".", "").replace(",", ".");
        double itemDiscount = (Double.parseDouble(discountTextFixed) / 100);

        double newItemPrice = itemPriceDouble - (itemPriceDouble * itemDiscount);

        WebElement priceTotalContFinal = priceContainer.findElement(By.xpath("//*[@class='text-center cart-total-product']"));
        WebElement priceTotal = priceTotalContFinal.findElement(By.xpath("//*[@class='product-item-prices']"));
        String totalAmount = priceTotal.getText();
        String totalAmountTextFixed = totalAmount.replace("BAM", "").replace(".", "").replace(",", ".");
        double totalAmountDouble = Double.parseDouble(totalAmountTextFixed);


        Assert.assertEquals("Očekivan broj izabranih artikala u korpi nije tačan", quantity, cartInfoNum.trim());
        Assert.assertEquals( "Izračunata ukupna vrednost nije očekivana",(newItemPrice * selectedQuantity), totalAmountDouble,0.05);

    }
}
