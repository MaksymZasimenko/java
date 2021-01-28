import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day19 {
    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://weather.com");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebDriverWait wait1 = new WebDriverWait(driver, 6);

        //Print pop-up massage
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='PrivacyDataNotice--mainParagraph--3LR5m']"))));
        System.out.println(driver.findElement(By.xpath("//p[@class='PrivacyDataNotice--mainParagraph--3LR5m']")).getText());

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i = 0; i <=8; i++){
            js.executeScript("window.scrollBy(0,2000)","");
            Thread.sleep(1000);
        }

        //Capture current window
        String currentWindowID = driver.getWindowHandle();
        //Caprute urls to social media pages
        List<WebElement> ls = driver.findElements(By.xpath("//a[@class='LinkList--Link--zzd7M']"));
        ls.get(0).click();
        //Capture multiple windows
        //Switch to facebook
        Set<String> windows  = driver.getWindowHandles();
       for(String window : windows){
           if(!window.equals(currentWindowID)){
               driver.switchTo().window(window);
           }
       }
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(currentWindowID);

        //Switch to twitter
        ls.get(1).click();
        windows = driver.getWindowHandles();
        for(String window : windows){
            if(!window.equals(currentWindowID)){
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(currentWindowID);

        //Switch to Youtube
        ls.get(3).click();
        windows = driver.getWindowHandles();
        for(String window : windows){
            if(!window.equals(currentWindowID)){
                driver.switchTo().window(window);
            }
        }
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(currentWindowID);

        //Scroll up
        for(int i = 0; i <=9; i++){
            js.executeScript("window.scrollBy(0,-2000)","");
            Thread.sleep(1000);
        }

        //Click on 10 days weather
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='10 Day']")))).click();

        //Print out weather for 10 days
        List<WebElement> allDays = driver.findElements(By.className("Disclosure--themeList--uBa5q"));
        for(WebElement element:allDays){
            System.out.println(element.getText()+"---");
        }

        driver.close();
    }
}
