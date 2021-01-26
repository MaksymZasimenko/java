import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day8 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:/www.practiceselenium.com");

//System.out.println(driver.findElement(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']")).getText());
//STEP 1: Print out menu button values
        List<WebElement> menuButtons = driver.findElements(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']/li"));
        menuButtons.forEach(a -> System.out.println(a.getText()));
//STEP 2: Click on Our Passion button
        menuButtons.get(1).click();
//STEP 3: Print out all text displayed in main section
        List<WebElement> allText = driver.findElements(By.xpath("//div[@id='wsb-canvas-template-container']/div"));
        System.out.println(allText.get(21).getText());
        System.out.println(allText.get(19).getText());
        System.out.println(allText.get(17).getText());
        System.out.println(allText.get(12).getText());
//STEP 4: Click on Menu button
        menuButtons = driver.findElements(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']/li"));
        menuButtons.get(2).click();
//STEP 5: Print out name of the teas listed in Menu page
        System.out.println();
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453230000']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231072']")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='wsb-element-00000000-0000-0000-0000-000453231735']")).getText());
//STEP 6: Click Check Out button
        menuButtons = driver.findElements(By.xpath("//ul[@class='wsb-navigation-rendered-top-level-menu ']/li"));
        menuButtons.get(4).click();
//STEP 7: Fill out all fields
        List<WebElement> inputFields = driver.findElements(By.xpath("//div[@class='controls']/input"));
        inputFields.get(0).sendKeys("Kuba");
        inputFields.get(1).sendKeys("Last");
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("12345 Main St");
        driver.findElement(By.xpath("//select[@id='card_type']")).sendKeys("Visa");
        inputFields.get(2).sendKeys("12345678");
        inputFields.get(3).sendKeys("Kuba Last");
        inputFields.get(4).sendKeys("verified");
//STEP 8: Click on Place Order
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        Thread.sleep(2000);

        driver.close();
    }
}
