package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.SignInPage;
import com.bookswagon.qa.utility.TestUtil;
import org.testng.annotations.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

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
    @Description("Verify sign in with valid credentials")
    @Severity(SeverityLevel.NORMAL)
    @Story("Authentication")
    public void SignInTest() throws InterruptedException {
        signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
    }

    @Test
    @Description("Verify sign in with multiple credentials")
    @Severity(SeverityLevel.NORMAL)
    @Story("Authentication")
    public void SignInMultipleTest() throws InterruptedException{
        signInPage.SignInMultiple();
    }

    @Test(dataProvider = "credentials")
    @Description("Verify sign in with provided credentials")
    @Severity(SeverityLevel.NORMAL)
    @Story("Authentication")
    public void SignInTest(String mobileOrEmail, String password) throws InterruptedException {
        signInPage.SignIn(mobileOrEmail, password);
    }

    @AfterMethod
    public void redirectingHomepage(){
        //driver.quit();
    }
}
