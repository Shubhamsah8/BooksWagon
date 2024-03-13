package com.bookswagon.qa.testcases;

import com.bookswagon.qa.baseclass.BaseClass;
import com.bookswagon.qa.pages.HomePage;
import com.bookswagon.qa.pages.NewArrivals;
import com.bookswagon.qa.pages.SignInPage;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.bookswagon.qa.listener.TestListener.class)
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
    @Description("Verify price range slider functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Filtering")
    public void priceRangeSliderTest(){
        if(newArrivals!= null){
            newArrivals.selectPriceRange(50, 10);
        }
        else{
            System.out.println("Not Initialized Properly");
        }
    }

    @Test
    @Description("Verify discount range slider functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Filtering")
    public void discountRangeSliderTest(){
        if(newArrivals != null){
            newArrivals.selectDiscountRange(50, 10);
        }
        else {
            System.out.println("Not Initialized Properly");
        }
    }

    @Test
    @Description("Verify binding checkbox functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Filtering")
    public void BindingCheckBoxTest() throws InterruptedException {
        newArrivals.selectBindingCheckBox("1");
    }

    @Test
    @Description("Verify language checkbox functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Filtering")
    public void LanguageCheckBoxTest() throws InterruptedException{
        newArrivals.selectLanguageCheckBox("English");
    }

    @Test
    @Description("Verify 'Read More' link functionality")
    @Severity(SeverityLevel.NORMAL)
    @Story("Navigation")
    public void ReadMoreClickTest(){
        newArrivals.readMoreClick();
    }
}
