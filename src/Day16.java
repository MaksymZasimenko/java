import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Day16 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);
        driver.get("http://automation.techleadacademy.io/?#/synchronization");
        driver.findElement(By.id("input-text")).sendKeys("Apple");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        explicitWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='text-display']")), "Apple"));
        WebElement textElement = driver.findElement(By.xpath("//div[text()='Apple']"));
        System.out.println(textElement.getText());
        driver.close();
    }
}
