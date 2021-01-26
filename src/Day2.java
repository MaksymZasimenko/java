import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement inputBar = driver.findElement(By.name("q"));
        inputBar.sendKeys("Selenium practice");


           Thread.sleep(2000);

        WebElement searchBtn = driver.findElement(By.name("btnk"));
        searchBtn.click();
        //System.out.println(searchBtn.getText());
    }
}



