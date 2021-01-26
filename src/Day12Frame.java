import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day12Frame {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/?#/iframes");

        driver.switchTo().frame("parent-iframe");

       driver.switchTo().frame("budget-tracker");

       driver.findElement(By.id("t-name")).sendKeys("Phone");
       driver.findElement(By.id("t-amount")).sendKeys("1000");
       driver.findElement(By.id("add-btn")).click();

       String transaction = driver.findElement(By.xpath("//tbody[@id='tbody']//td[1]")).getText();
       String amounts = driver.findElement(By.xpath("//tbody[@id='tbody']//td[2]")).getText();

       driver.switchTo().defaultContent();

       driver.switchTo().frame("note");

       driver.findElement(By.className("note-title")).sendKeys(transaction);
       driver.findElement(By.className("note-textarea")).sendKeys(amounts);

       driver.findElement(By.xpath("//i[@class='fas fa-save text-light save-note']")).click();

       driver.findElement(By.xpath("//li[@class='list-group-item']")).click();

        System.out.println(driver.findElement(By.xpath("//input[@class='note-title']")).getText());

        Thread.sleep(2000);
        driver.close();



////Switching to parent iframe
//        driver.switchTo().frame("parent-iframe");
////Switching to child iframe
//        driver.switchTo().frame("budget-tracker");
////Entering transaction details
//        driver.findElement(By.id("t-name")).sendKeys("Cloud Service");
//        driver.findElement(By.id("t-amount")).sendKeys("2000");
//        driver.findElement(By.id("add-btn")).click();
////Switching to parent iframe
//        driver.switchTo().parentFrame();
////Switching to wiki iframe
//        driver.switchTo().frame("wikipedia");
////Printing our languages of Wiki page
//        List<WebElement> listOfLanguages = driver.findElements(By.xpath("//div[starts-with(@class, 'central-featured-lang')]//strong"));
//        listOfLanguages.forEach(a -> System.out.println(a.getText()));
////STEP 10: Close the window
        //Thread.sleep(2000);
       // driver.close();
    }
}
