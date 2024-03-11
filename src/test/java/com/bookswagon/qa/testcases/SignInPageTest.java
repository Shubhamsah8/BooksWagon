package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends BaseClass {

    SignInPage signInPage;

    public SignInPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        signInPage = new SignInPage();
    }

    @Test
    public void SignInTest() throws InterruptedException {
        signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Test
    public void SignInMultipleTest() throws InterruptedException{
        signInPage.SignInMultiple();
    }

//    @Test
//    public void SignInMultiTest() throws InterruptedException {
//        signInPage.SignInMulti();
//    }

    @AfterMethod
    public void redirectingHomepage(){
        //driver.quit();
    }
}
