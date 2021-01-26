import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day3 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/#/home");
//System.out.println(driver.findElement(By.id("main-text")).getText());
        System.out.println("Text: " + driver.findElement(By.id("selenium-img")).getText());
        WebElement phpTravelsLink = driver.findElement(By.id("php-travels"));
        System.out.println(phpTravelsLink.getText());
        String expectedPHPUrl = "https://phptravels.com/demo/";
        String actualPHPLink = phpTravelsLink.getAttribute("href");
        System.out.println("expected URL: " + expectedPHPUrl);
        System.out.println("actual URL: " + actualPHPLink);
        if (expectedPHPUrl.equalsIgnoreCase(actualPHPLink)) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        System.out.println(phpTravelsLink.getTagName());

        WebElement mainTextArea = driver.findElement(By.name("paragraph"));

        System.out.println(mainTextArea.isDisplayed());

        WebElement internetLinkText = driver.findElement(By.id("internet"));
        System.out.println(internetLinkText.isEnabled());

        WebElement navBtn = driver.findElement(By.className("navbar-brand"));
        System.out.println(navBtn.getText());



            List<WebElement> navBtns = driver.findElements(By.className("navbar-brand"));
        System.out.println(navBtns.size());

        for(WebElement element : navBtns){
            System.out.println(element.getText());
        }

        navBtns.forEach( a -> System.out.println(a.getText()));

        Thread.sleep(2000);
        driver.close();
    }
}
