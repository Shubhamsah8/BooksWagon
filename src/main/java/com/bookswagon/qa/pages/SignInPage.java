package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
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

}
