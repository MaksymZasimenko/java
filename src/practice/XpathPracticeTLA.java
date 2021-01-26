package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathPracticeTLA {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://canvas.techleadacademy.io/");

        driver.findElement(By.xpath("//input[@id='pseudonym_session_unique_id']")).sendKeys("zasimenkomax@gmail.com");
        driver.findElement(By.xpath("//input[@id='pseudonym_session_password']")).sendKeys("Maksym$$");

        try{
           Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//button[@class='Button Button--login']")).click();

        driver.findElement(By.xpath("//a[@id='global_nav_courses_link']")).click();



//        try{
//            Thread.sleep(2000);
//        }catch (InterruptedException e){
//
//        }
//
//
//
//        driver.close();
    }
}
