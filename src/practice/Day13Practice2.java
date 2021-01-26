package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Day13Practice2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        driver.get("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        action.click(search).sendKeys("Weather").perform();
        action.click(search).doubleClick().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();

        action.click(driver.findElement(By.name("btnK"))).perform();

        List<WebElement> heading = driver.findElements(By.xpath("//span[@role='heading']"));
        for (WebElement el: heading) {
            System.out.println(el.getText());
        }


        driver.navigate().back();

        action.click(search).sendKeys("yahoo").keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

    }
}
