package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void loginPageTitleTest(){
        String title = signUpPage.ValidateSignUpPageTitle();
        Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
    }

    @Test
    public void SignUpTest() throws InterruptedException {
        signUpPage.SignUp(properties.getProperty("username"), properties.getProperty("mobileNumber"));
    }

//    @AfterMethod
//    public void close(){
//        driver.quit();
//    }
}
