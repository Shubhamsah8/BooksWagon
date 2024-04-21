package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchedBook extends BaseClass {

    @FindBy (xpath = "//span[contains(@class,'themecolor headingtext')]")
    WebElement bookName;

    @FindBy (xpath = "//div[@id='ctl00_phBody_ProductDetail_CartBoxWeb_divaction']//a[1]")
    WebElement addToCart;

    @FindBy (xpath = "//div[@id='ctl00_phBody_ProductDetail_CartBoxWeb_divaction']//a[3]")
    WebElement buyNow;

    @FindBy (xpath = "//div[@id='divNotifyMsg']/following-sibling::a[1]")
    WebElement wishList;

    public void addingToCart() throws InterruptedException {
        Thread.sleep(2000);
        addToCart.click();
    }

    public void buyingNow() throws InterruptedException{
        Thread.sleep(2000);
        buyNow.click();
    }

}
