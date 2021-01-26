package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrtizDayAndTime {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orbitz.com");

        WebElement checkIn = driver.findElement(By.id("d1-btn"));
        WebElement checkOut = driver.findElement(By.id("d2-btn"));

        //date format 2021-02-09
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String dateToday = formatter.format(date);
        date = date.plusWeeks(2);
        String dayIn2Weeks = formatter.format(date);

        checkIn.sendKeys(dateToday);
        checkOut.sendKeys(dayIn2Weeks);
    }
}
