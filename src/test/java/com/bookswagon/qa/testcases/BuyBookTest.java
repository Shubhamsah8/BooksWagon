package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.SignInPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
public class BuyBookTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;

    @BeforeMethod
    public void setup(){
        initialization();
        signInPage = new SignInPage();
    }

    @Test(priority = 1)
    @Description("Verify sign in with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Authentication")
    public void SignInTest() throws InterruptedException {
        try {

            logger.info("Starting SignInTest...");

            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            homePage.returnHome();

            logger.info("SignInTest completed successfully");
        } catch (WebDriverException e) {
            logger.error("An unexpected WebDriverException occurred", e);
            throw e;
        } catch (InterruptedException e) {
            logger.error("InterruptedException occurred", e);
            throw e;
        } catch (Exception e) {
            logger.error("An unexpected error occurred", e);
            throw e;
        }
    }

    @Test(priority = 2, dependsOnMethods = "SignInTest")
    @Description("Verify search functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Book Search")
    public void searchBookTest() throws InterruptedException {
        try {
            logger.info("Starting searchBookTest...");

            signInPage = new SignInPage();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));

            // Perform book search
            homePage.searchBook(properties.getProperty("bookname"));

            logger.info("searchBookTest completed successfully");
        } catch (WebDriverException e) {
            logger.error("An unexpected WebDriverException occurred", e);
            throw e;
        } catch (Exception e) {
            logger.error("An unexpected error occurred", e);
            throw e;
        }
    }

}
