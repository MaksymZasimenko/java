import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day10 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/selectclass");
//-------- 1 ---------
        Select select = new Select(driver.findElement(By.id("cars")));
        System.out.println(select.isMultiple());
        for(int i = 0; i < 3; i++){
            select.selectByIndex(i);
        }
//-------- 2 ---------
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Run']")).click();
        System.out.println(driver.findElement(By.xpath("//button[@type='button']")).isDisplayed());
//-------- 3 ---------
        driver.findElement(By.id("exampleRadios1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("exampleRadios3")).click();
        driver.findElement(By.id("defaultCheck1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("defaultCheck3")).click();

    }
}
