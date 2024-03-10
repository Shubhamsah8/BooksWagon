package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"ctl00_lblUser\"]")
    WebElement myAccount;

    @FindBy(linkText = "New to Bookswagon? Sign up")
    WebElement newUser;

    @FindBy(xpath = "//input[contains(@placeholder, 'Name')]")
    WebElement username;

    @FindBy(xpath = "//input[contains(@placeholder, 'Enter Mobile Number')]")
    WebElement mobileNumber;

    @FindBy(xpath = "//div[contains(@role, 'presentation')]")
    WebElement captcha;

    @FindBy(xpath = "//input[contains(@type, 'checkbox')]")
    WebElement subscribeCheckBox;

    @FindBy(xpath = "//input[contains(@placeholder, 'Enter OTP')]")
    WebElement OTP;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_txtPassword\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_txtConfirmPwd\"]")
    WebElement confirmPassword;

    @FindBy(xpath =  "//*[@id=\"ctl00_phBody_SignUp_btnContinue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElement signUp;

    @FindBy(xpath = "//*[@id=\"loginModal\"]/div/div/div[2]/div[5]/div[1]/div[4]/div/a[2]")
    WebElement existingUserButton;

    @FindBy(xpath = "//img[contains(@title, 'Login with Google')]")
    WebElement googleLoginButton;

    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    public String ValidateSignUpPageTitle(){
        return driver.getTitle();
    }

    public void SignUp(String Username, String MobileNumber) throws InterruptedException {
        myAccount.click();
        newUser.click();
        username.sendKeys(Username);
        mobileNumber.sendKeys(MobileNumber);
        //captcha.click();
        //subscribeCheckBox.click();\
        Thread.sleep(10000);
        continueButton.click();
        //OTP.sendKeys("1234"); Manually type the OTP
        Thread.sleep(5000);
        password.sendKeys(properties.getProperty("password"));
        confirmPassword.sendKeys(properties.getProperty("password"));
        signUp.click();
    }
}
