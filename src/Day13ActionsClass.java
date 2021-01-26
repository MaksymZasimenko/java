import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day13ActionsClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Actions action = new Actions(driver);
        driver.get("http://automation.techleadacademy.io/?#/iframes");
        Thread.sleep(1000);
        driver.switchTo().frame("parent-iframe");
        Thread.sleep(1000);
        WebElement iframeText = driver.findElement(By.id("iframe-text"));
        Thread.sleep(1000);
//Option1:
action.click(iframeText).doubleClick().keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
//Option2:
       // action.keyDown(iframeText, Keys.COMMAND).sendKeys("a").sendKeys("c").keyUp(Keys.COMMAND).perform();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("note");
        Thread.sleep(1000);
        WebElement noteField = driver.findElement(By.className("note-title"));
        Thread.sleep(1000);
        WebElement textField = driver.findElement(By.className("note-textarea"));
        Thread.sleep(2000);
        action.sendKeys(noteField, "Kuba").keyDown(textField, Keys.COMMAND).sendKeys("v").perform();
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath("//i[@class='fas fa-save text-light save-note']"))).perform();

//        WebElement inputField = driver.findElement(By.id("message"));
//        actions.sendKeys(inputField, "TLA Automation").perform();
//        Thread.sleep(2000);
//        WebElement inputField2 = driver.findElement(By.id("a"));
//        actions.click(inputField).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(inputField2, "sds").perform();
//        Thread.sleep(1000);
//        actions.sendKeys(inputField2, "ABC").perform();

//        Actions actions = new Actions(driver);
//        driver.get("http://automation.techleadacademy.io/?#/actionclass");
//        WebElement buttonDblClick = driver.findElement(By.xpath("//button[@class='btn btn-warning m-2 btn-lg']"));
//        Thread.sleep(1000);
//        actions.doubleClick(buttonDblClick).perform();
//        Thread.sleep(1000);
//        WebElement rightClick = driver.findElement(By.xpath("//button[@class='btn btn-info btn-lg m-2']"));
//        actions.contextClick(rightClick).perform();

    }
}
