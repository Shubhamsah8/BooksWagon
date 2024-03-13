package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.RequestBook;
import com.bookswagon.qa.pages.SignInPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
public class RequestBookTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;
    public RequestBook requestBook;

    public RequestBookTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        try {
            initialization();
            signInPage = new SignInPage();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            homePage.returnHome();
            requestBook = homePage.requestBookClick();
        } catch (WebDriverException | InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    @Description("Fill request book form")
    @Severity(SeverityLevel.NORMAL)
    @Story("Request Book")
    public void FillRequestBook(){
        requestBook.ISBNinput(properties.getProperty("ISBN"));
        requestBook.BookTitleInput(properties.getProperty("bookTitle"));
        requestBook.AuthorInput(properties.getProperty("author"));
        requestBook.Quantity("3");
        requestBook.Email(properties.getProperty("email"));
        requestBook.MobilePhone(properties.getProperty("mobileNumber"));
        requestBook.SubmitClick();
    }
}
