import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Day10MultipleWindows {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        String currentWindowID = driver.getWindowHandle();
        System.out.println(currentWindowID);
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[text()='Launch TLA']")).click();
        Thread.sleep(2000);

        Set<String> windows = driver.getWindowHandles();

        for(String s: windows){
            if(!s.equals(currentWindowID)){
                driver.switchTo().window(s);
            }
        }

        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.quit();
    }
}
