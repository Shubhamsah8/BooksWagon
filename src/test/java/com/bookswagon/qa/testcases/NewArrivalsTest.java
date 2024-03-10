package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.NewArrivals;
import com.bookswagon.qa.pages.SignInPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewArrivalsTest extends BaseClass {

    public SignInPage signInPage;
    public HomePage homePage;
    public NewArrivals newArrivals;
    public NewArrivalsTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        try {
            initialization();
            signInPage = new SignInPage();
            homePage = signInPage.SignIn(properties.getProperty("email"), properties.getProperty("password"));
            newArrivals = homePage.newArrivalsClick();
        } catch (WebDriverException | InterruptedException e){
            e.getMessage();
        }
    }

    @Test
    public void priceRangeSliderTest(){
        if(newArrivals!= null){
            newArrivals.selectPriceRange(50, 10);
        }
        else{
            System.out.println("Not Initialized Properly");
        }
    }

    @Test
    public void discountRangeSliderTest(){
        if(newArrivals != null){
            newArrivals.selectDiscountRange(50, 10);
        }
        else {
            System.out.println("Not Initialized Properly");
        }
    }

    @Test
    public void BindingCheckBoxTest() throws InterruptedException {
        newArrivals.selectBindingCheckBox("1");
    }

    @Test
    public void LanguageCheckBoxTest() throws InterruptedException{
        newArrivals.selectLanguageCheckBox("English");
    }

    @Test
    public void ReadMoreClickTest(){
        newArrivals.readMoreClick();
    }
}
