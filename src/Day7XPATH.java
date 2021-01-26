import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day7XPATH {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name='q']"));
        input.sendKeys("SDET position");
        input.submit();

            Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='esVihe']")).click();

            Thread.sleep(2000);

        List<WebElement> jobs = driver.findElements(By.xpath("//div[@jsname='CaV2mb']"));

        for(WebElement element : jobs){
            System.out.println(element.getText());
        }

        driver.close();

    }
}
