package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day12HM {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //STEP1
        driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");
        //STEP2
//        driver.findElement(By.xpath("//button[@type='button']")).click();
//        driver.findElement(By.xpath("//a[contains(text(), '1st Level Supervisor')]")).click();
//        Thread.sleep(2000);
        driver.findElement(By.id("btnLogin")).click();
        //STEP3
        driver.findElement(By.xpath("//li[@id='menu__Performance']//a//span[3]")).click();
        driver.findElement(By.xpath("//li[@id='menu_performanceTracker_EmployeeTrackers']//a//span[3]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Tracker List')]")).click();
        //STEP4
        driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Performance Trackers')]")).getText());
        //driver.switchTo().frame(driver.findElement(By.id("noncoreIframe")));
        Thread.sleep(1000);
        //STEP5
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(5000);
        //STEP6
        System.out.println(driver.findElement(By.id("pim.navbar.employeeName")).getText());
        System.out.println(driver.findElement(By.className("small-subtitle")).getText());
        driver.close();


        //System.out.println(driver.findElement(By.xpath("//div[@class='nav-wrapper customized-orange']")).getText());
    }
}
