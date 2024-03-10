package com.bookswagon.qa.baseclass;

import com.bookswagon.qa.utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;

    public BaseClass(){
        try{
            properties = new Properties();

            FileInputStream inputStream = new FileInputStream("C:\\Users\\RYZEN\\IdeaProjects\\BooksWagon\\src\\main\\java\\com\\bookswagon\\qa\\config\\config.properties");
            properties.load(inputStream);
            System.out.println("Properties loaded successfully: " + properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        new BaseClass();
        String browserName = properties.getProperty("browser");

        if(browserName.equals("Chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));
    }
}
