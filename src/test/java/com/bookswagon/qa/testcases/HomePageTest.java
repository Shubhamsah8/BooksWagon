package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.SignInPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        try {
            initialization();
            signInPage = new SignInPage();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            homePage.returnHome();
        } catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void searchBookTest() throws InterruptedException {
        homePage.searchBook(properties.getProperty("bookname"));
    }

    @Test(priority = 2)
    public void newArrivalsTest() throws InterruptedException {
        homePage.newArrivalsClick();
    }

    @Test(priority = 4)
    public void bestSellersTest() throws InterruptedException{
        homePage.bestSellersClick();
    }

    @Test(priority = 3)
    public void boxSetsTest() throws InterruptedException{
        homePage.boxSetsClick();
    }

    @Test(priority = 5)
    public void fictionBookTest() throws InterruptedException{
        homePage.fictionBooksClick();
    }

    @Test(priority = 6)
    public void awardWinnersTest() throws InterruptedException{
        homePage.awardWinnersClick();
    }

    @Test(priority = 7)
    public void featuredAuthors() throws InterruptedException{
        homePage.featuredAuthorsClick();
    }

//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }
}
