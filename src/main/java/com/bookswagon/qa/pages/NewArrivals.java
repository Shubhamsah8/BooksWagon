package com.bookswagon.qa.pages;

import com.bookswagon.qa.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sound.midi.SysexMessage;
import java.util.List;

public class NewArrivals extends BaseClass {

    Actions actions = new Actions(driver);
    @FindBy(xpath = "//*[@id=\"slider-range\"]/span[1]")
    WebElement priceRangeSliderLeft;

    @FindBy(xpath = "//*[@id=\"slider-range\"]/span[2]")
    WebElement priceRangeSliderRight;

    @FindBy(xpath = "//*[@id=\"discount-range\"]/span[1]")
    WebElement discountRangeSliderLeft;

    @FindBy(xpath = "//*[@id=\"discount-range\"]/span[2]")
    WebElement discountRangeSliderRight;

    @FindBy(xpath = "//input[@type='checkbox' and @name='chkBinding']")
    List<WebElement> bindingCheckBoxes;

    @FindBy(xpath = "//input[@type='checkbox' and @name='chkLanguage']")
    List<WebElement> languageCheckBoxes;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div[1]/div[3]/div[1]/div[5]/a")
    WebElement readMore;

    //PageFactory to Initialize the Elements
    public NewArrivals(){
        PageFactory.initElements(driver, this);
    }
//    public List<WebElement> getBindingCheckBoxes(){
//        return bindingCheckBoxes;
//    }

    // Method to select a checkbox by index from the binding checkboxes list
    public void selectBindingCheckBox(String value) {
        for (WebElement checkbox : bindingCheckBoxes) {
            String checkboxValue = checkbox.getAttribute("value");
            if (checkboxValue.equals(value)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                break;
            }
        }
    }

//    public List<WebElement> getLanguageCheckBoxes(){
//        return languageCheckBoxes;
//    }

    // Method to select a checkbox by index from the language list
    public void selectLanguageCheckBox(String value){
        for(WebElement checkbox : languageCheckBoxes){
            String checkboxValue = checkbox.getAttribute("value");
            if(checkboxValue.equals(value)){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                break;
            }
        }
    }

    //Manipulating the Sliders of Price Range
    public void selectPriceRange(int percentageLeft, int percentageRight){

        int width = priceRangeSliderLeft.getSize().getWidth();
        int xoffset = width*(percentageLeft)/10;
        actions.dragAndDropBy(priceRangeSliderLeft, xoffset, 0).build().perform();

        int width1 = priceRangeSliderRight.getSize().getWidth();
        int xoffset1 = width1*(percentageRight)/10;
        actions.dragAndDropBy(priceRangeSliderRight, xoffset1, 0).build().perform();


    }

    //Manipulating the Sliders of Discount Range
    public void selectDiscountRange(int percentageLeft, int percentageRight){

        int width = discountRangeSliderLeft.getSize().getWidth();
        int xoffset = width*(percentageLeft)/10;
        actions.dragAndDropBy(discountRangeSliderLeft, xoffset, 0).build().perform();

        int widht1 = discountRangeSliderRight.getSize().getWidth();
        int xoffset1 = widht1*(percentageRight)/10;
        actions.dragAndDropBy(discountRangeSliderRight, xoffset1, 0).build().perform();
    }

    //Clicking the Read More
    public void readMoreClick(){
        readMore.click();
    }
}
