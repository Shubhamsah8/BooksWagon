package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.SignInPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
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
    @Description("Verify search functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search")
    public void searchBookTest() throws InterruptedException {
        homePage.searchBook(properties.getProperty("bookname"));
    }

    @Test(priority = 2)
    @Description("Verify new arrivals link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void newArrivalsTest() throws InterruptedException {
        homePage.newArrivalsClick();
    }

    @Test(priority = 4)
    @Description("Verify best sellers link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void bestSellersTest() throws InterruptedException{
        homePage.bestSellersClick();
    }

    @Test(priority = 3)
    @Description("Verify box sets link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void boxSetsTest() throws InterruptedException{
        homePage.boxSetsClick();
    }

    @Test(priority = 5)
    @Description("Verify fiction books link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void fictionBookTest() throws InterruptedException{
        homePage.fictionBooksClick();
    }

    @Test(priority = 6)
    @Description("Verify award winners link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void awardWinnersTest() throws InterruptedException{
        homePage.awardWinnersClick();
    }

    @Test(priority = 7)
    @Description("Verify featured authors link")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void featuredAuthors() throws InterruptedException{
        homePage.featuredAuthorsClick();
    }

//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }
}
