package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
public class SignUpPageTest extends BaseClass {
    SignUpPage signUpPage;

    public SignUpPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        signUpPage = new SignUpPage();
    }

    @Test
    @Description("Verify sign up page title")
    @Severity(SeverityLevel.NORMAL)
    @Story("Validation")
    public void loginPageTitleTest(){
        String title = signUpPage.ValidateSignUpPageTitle();
        Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
    }

    @Test
    @Description("Verify sign up functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Story("SignUp")
    public void SignUpTest() throws InterruptedException {
        signUpPage.SignUp(properties.getProperty("username"), properties.getProperty("mobileNumber"));
    }

//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }
}
