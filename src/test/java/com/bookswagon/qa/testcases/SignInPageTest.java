package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.listener.TestListener;
import com.bookswagon.qa.pages.SignInPage;
import com.bookswagon.qa.utility.TestUtil;
import org.testng.annotations.*;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
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

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return TestUtil.getTestData("Sheet1");
    }

    @Test
    public void SignInTest() throws InterruptedException {
        signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Test
    public void SignInMultipleTest() throws InterruptedException{
        signInPage.SignInMultiple();
    }

    @Test(dataProvider = "credentials")
    public void SignInTest(String mobileOrEmail, String password) throws InterruptedException {
        signInPage.SignIn(mobileOrEmail, password);
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
