package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestBook extends BaseClass {

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtISBN\"]")
    WebElement ISBN13;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtTitle\"]")
    WebElement bookTitle;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtAuthor\"]")
    WebElement author;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtQty\"]")
    WebElement quantity;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtEmailReq\"]")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtPhone\"]")
    WebElement mobilePhone;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_imgbtnSave\"]")
    WebElement submit;

    public RequestBook(){
        PageFactory.initElements(driver, this);
    }

    //Method to send the ISBN keys
    public void ISBNinput(String ISBN){
        ISBN13.sendKeys(ISBN);
    }

    //Method to send the Book Title Keys
    public void BookTitleInput(String bookTitleInput){
        bookTitle.sendKeys(bookTitleInput);
    }

    //Method to send the Author Keys
    public void AuthorInput(String authorInput){
        author.sendKeys(authorInput);
    }

    //Method to send the Quantity keys
    public void Quantity(String quantityInput){
        quantity.clear();
        quantity.sendKeys(quantityInput);
    }

    //Method to send the email details
    public void Email(String emailInput){
        email.sendKeys(emailInput);
    }

    //Method to send the mobile phone details
    public void MobilePhone(String mobilePhoneInput){
        mobilePhone.sendKeys(mobilePhoneInput);
    }

    public void SubmitClick(){
        submit.click();
    }
}
