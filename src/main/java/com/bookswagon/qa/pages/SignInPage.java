package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.utility.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/header/div[1]/div/div[1]/a")
    WebElement booksWagonImage;
    @FindBy(xpath = "//*[@id=\"ctl00_lblUser\"]")
    WebElement myAccount;

    @FindBy(xpath = "//input[contains(@placeholder, 'Mobile/Email')]")
    WebElement mobileOrEmail;

    @FindBy(xpath = "//input[contains(@type, 'password')]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_plnLoginPassword\"]/div[1]/div[3]/span/a")
    WebElement forgetPassword;

    @FindBy(xpath = "//a[contains(@onclick, 'return ValidateLoginPassword();')]")
    WebElement login;

    @FindBy(xpath = "//a[contains(@onclick, 'return ValidateEmail();')]")
    WebElement requestOTP;

    @FindBy(xpath = "//img[contains(@title, 'Login with Google')]")
    WebElement googleLoginButton;

    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    // Method to sign in into the Bookswagon website
    public HomePage SignIn(String mobileOrEmailInput, String passwordInput) throws InterruptedException {
        myAccount.click();
        mobileOrEmail.sendKeys(mobileOrEmailInput);
        password.sendKeys(passwordInput);
        //forgetPassword.click();
        login.click();

        return new HomePage();
    }

    // Method to give multiple inputs in sign in page
    public HomePage SignInMultiple() throws InterruptedException {
        Object[][] testData = TestUtil.getTestData("Sheet1");
        String mobileOrEmailInput = testData[1][0].toString();
        String passwordInput = testData[0][1].toString();
        myAccount.click();
        mobileOrEmail.sendKeys(mobileOrEmailInput);
        password.sendKeys(passwordInput);
        //forgetPassword.click();
        login.click();

        return new HomePage();
    }

    // Method to sign in using test data from a predefined sheet
    public HomePage SignInUsingTestData() throws InterruptedException {
        Object[][] testData = TestUtil.getTestData("Sheet1");
        String mobileOrEmailInput = testData[0][0].toString(); // Assuming email/mobile is in the first column
        String passwordInput = testData[0][1].toString(); // Assuming password is in the second column
        
        myAccount.click();
        mobileOrEmail.sendKeys(mobileOrEmailInput);
        password.sendKeys(passwordInput);
        login.click();

        return new HomePage();
    }

    // Method to give the Multiple inputs in sign in page at the same time

//    public void SignInMulti() throws InterruptedException {
//        Object[][] testData = TestUtil.getTestData("Sheet1"); // Get test data from Excel
//
//        for (int i = 0; i < testData.length; i++) {
//            String mobileOrEmailInput = testData[i][0].toString(); // Assuming email is in the first column
//            String passwordInput = testData[i][1].toString(); // Assuming password is in the second column
//
//            myAccount.click();
//            mobileOrEmail.sendKeys(mobileOrEmailInput);
//            password.sendKeys(passwordInput);
//            //forgetPassword.click();
//            login.click();
//            Thread.sleep(5000);
//            driver.navigate().back();
//        }
//    }
}
