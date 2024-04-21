package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults extends BaseClass {

    @FindBy(xpath = "//div[@id='listSearchResult']/div[1]/div[3]/div[1]/a[1]")
    WebElement firstResult;

    public SearchResults(){
        PageFactory.initElements(driver, this);
    }

    public void clickBook() throws InterruptedException {
        Thread.sleep(5000);
        firstResult.click();
    }
}
