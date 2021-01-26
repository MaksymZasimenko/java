package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSel {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        WebElement inputBar = driver.findElement(By.name("q"));
        inputBar.sendKeys("pornhub");
        inputBar.submit();

        driver.findElement(By.partialLinkText("Pornhub: Free Porn Videos & Sex Movies - Porno, XXX, Porn ...")).click();

        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys("HD porn");
        searchBar.submit();









    }
}
