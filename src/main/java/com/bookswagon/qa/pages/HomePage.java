package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//img[contains(@alt, 'Bookswagon-24x7 online bookstore')]")
    WebElement booksWagonImage;

    @FindBy(xpath = "//input[contains(@id, 'inputbar')]")
    WebElement searchBar;

    @FindBy(xpath = "//input[contains(@name, 'btnTopSearch')]")
    WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"ctl00_linewrelease\"]/a")
    WebElement newArrivals;

    @FindBy(xpath = "//*[@id=\"ctl00_lipreorder\"]/a")
    WebElement boxSets;

    @FindBy(xpath = "//*[@id=\"ctl00_libestseller\"]/a")
    WebElement bestSellers;

    @FindBy(xpath = "//*[@id=\"ctl00_liTextBook\"]/a")
    WebElement fictionBooks;

    @FindBy(xpath = "//*[@id=\"ctl00_liAW\"]/a")
    WebElement awardWinners;

    @FindBy(xpath = "//*[@id=\"ctl00_liRequestBook\"]/a")
    WebElement featuredAuthors;

    @FindBy(xpath = "//*[@id=\"ctl00_liRequestBook\"]/a")
    WebElement todaysDeals;

    @FindBy(xpath = "//*[@id=\"ctl00_li1\"]/a")
    WebElement requestBook;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBook(String bookName) {
        searchBar.sendKeys(bookName);
        searchIcon.click();
    }

    //Method to click the books wagon image to return to homepage
    public void returnHome() throws InterruptedException {
        Thread.sleep(5000);
        booksWagonImage.click();
    }

    //Method to click the New Arrivals option
    public NewArrivals newArrivalsClick() {
        newArrivals.click();
        return new NewArrivals();
    }

    //Method to click the Best Sellers Option
    public BestSellers bestSellersClick() {
        bestSellers.click();
        return new BestSellers();
    }

    //Method to click the Box Sets Option
    public BoxSets boxSetsClick(){
        boxSets.click();
        return new BoxSets();
    }

    //Method to click the Ficition Books Option
    public FictionBooks fictionBooksClick() {
        fictionBooks.click();
        return new FictionBooks();
    }

    //Method to click the Award Winners Option
    public AwardWinners awardWinnersClick() {
        awardWinners.click();
        return new AwardWinners();
    }

    //Method to click the Featured Authors Option
    public FeaturedAuthors featuredAuthorsClick() {
        featuredAuthors.click();
        return new FeaturedAuthors();
    }

    //Method to click the Request Book
    public RequestBook requestBookClick(){
        requestBook.click();
        return new RequestBook();
    }
}
