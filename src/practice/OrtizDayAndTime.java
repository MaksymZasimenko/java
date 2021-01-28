package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        String dayIn2Weeks = formatter.format(date);
        driver.manage().window().maximize();
        checkIn.click();

        List<WebElement> elements = driver.findElements(By.xpath("//td[@class='uitk-date-picker-day-number']"));
        for (int i = 0; i<elements.size(); i++){
            if(elements.get(i).equals(dateToday)){
                elements.get(i).click();
                date = date.plusWeeks(2);
            }
        }
    }
}
