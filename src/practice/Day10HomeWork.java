package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Day10HomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        String currentWindow = driver.getWindowHandle();

        List<WebElement> buttons = driver.findElements(By.xpath("//div/a"));
        for (WebElement element : buttons){
            System.out.println(element.getText());
        }

        driver.findElement(By.xpath("//div/a[3]")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for(String str : allWindows){
            if(!str.equals(currentWindow))
                driver.switchTo().window(str);
        }

        System.out.println(driver.findElement(By.className("_8eso")).getText());
        driver.close();

        //driver.switchTo().window(currentWindow);

    }
}
