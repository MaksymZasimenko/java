package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4HomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //First class task

        //Open webpage
        driver.get("https://www.saucedemo.com");
        //Printing out main text
        System.out.println(driver.getTitle());
        //Print out all Accepted usernames list

        System.out.println(driver.findElement(By.id("login_credentials")).getText());

        //Second class task

        //input credentials:
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login button
        driver.findElement(By.id("login-button")).click();


        System.out.println("---------------");
        //Third class task

        //find out each elements name
        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        //find out each elements price
        List<WebElement> price = driver.findElements(By.className("inventory_item_price"));
        //print out each element together
        for(int i = 0; i < names.size(); i++){
           System.out.println(names.get(i).getText() + " " + price.get(i).getText());
        }

        System.out.println("------------");

        //Fourth class task
        //click first item and open it
        driver.findElement(By.partialLinkText("Sauce Labs Backpack")).click();

        //Fifth class task
        //print out item name
        System.out.println(driver.findElement(By.className("inventory_details_name")).getText());
        //print out item description
        System.out.println(driver.findElement(By.className("inventory_details_desc")).getText());
        //print out item price
        System.out.println(driver.findElement(By.className("inventory_details_price")).getText());

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();// traces whats wrong if it fales
        }

        driver.close();


    }
}
