import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day5 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.get("http://automation.techleadacademy.io/#/home");
//
//        //STEP 1
//        List<WebElement> ls = driver.findElements(By.cssSelector(".navbar-brand"));
//        System.out.println(ls.size());
//        ls.forEach(a-> System.out.println(a.getText()));
//
//        //STEP 2
//        driver.findElement(By.cssSelector("a[href='#/actionclass']")).click();
//        Thread.sleep(2000);
//        driver.navigate().back();
//
//        //STEP 3
//        System.out.println("Img keyword: " + driver.findElement(By.cssSelector("img[id*='img'")));
//
//        //STEP4
//        driver.findElement(By.cssSelector("a[id=sauce-demo]:not([href*='practice'])")).click();
//
//
//        Thread.sleep(2000);
//
//        driver.quit();


        //Tesla assignment

//        driver.get("http://tesla.com");
//
//        driver.findElement(By.cssSelector("a[title=\"Order Now\"]")).click();
//
//        driver.navigate().back();
//
//        driver.findElement(By.cssSelector("a[title=\"Learn More\"]")).click();




    }
}
