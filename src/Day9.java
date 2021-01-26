import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.bcel.internal.generic.Visitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.util.List;

public class Day9 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/selectclass");

//
//        Select select = new Select(driver.findElement(By.name("select1")));
////By visible text
//        select.selectByVisibleText("One");
//        Thread.sleep(2000);
//        select.selectByVisibleText("Nine");
//        Thread.sleep(2000);
////By index
//        Select select2 = new Select(driver.findElement(By.name("select2")));
//        select2.selectByIndex(3);
//        Thread.sleep(2000);
//        select2.selectByIndex(9);
//        Thread.sleep(2000);
////By value
//        select.selectByValue("Five");
////get Options
//        List<WebElement> list = select.getOptions();
//        list.forEach(a -> System.out.println(a.getText()));
////isMultiple option
//        System.out.println(select.isMultiple());
//
//


    }
}
