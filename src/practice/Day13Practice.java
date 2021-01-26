package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day13Practice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
        driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).click();
        List<WebElement> login = driver.findElements(By.xpath("//a[@class='login-as']"));
        login.get(3).click();
        driver.findElement(By.xpath("//li[@id='menu__Performance']")).click();
        driver.findElement(By.xpath("//li[@id='menu_performanceTracker_EmployeeTrackers']")).click();
        driver.findElement(By.id("menu_performanceTracker_viewEmployeePerformanceTrackerList")).click();
        driver.switchTo().frame("noncoreIframe");
        driver.switchTo().frame("legacyViewHolder");
        driver.findElement(By.xpath("//a[text()='2018 Tracker for Linda']")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        for (WebElement eachRow: rows){
            WebElement log = eachRow.findElement(By.xpath("./td[2]"));
            WebElement date = eachRow.findElement(By.xpath("./td[5]"));
            System.out.println(log.getText() + " | " + date.getText());
        }
    }
}
