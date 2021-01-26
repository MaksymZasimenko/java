package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Day14JavaSkriptEx {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://amazon.com");


        //Example 2 move mouse weal down
//        Thread.sleep(2000);
//        js.executeScript("window.scrollBy(0, 2000)");

        WebElement carriersBtn = driver.findElement(By.xpath("//a[@class='nav_a' and text()='Careers']"));
        highlightElement(carriersBtn, driver);

       //Make career highlighted
//        js.executeScript("arguments[0].scrollIntoView(true);", carriersBtn);
//        js.executeScript("arguments[0].style.backgroundColor='yellow';", carriersBtn);



        //EXAMPLE 1 print page title
//        driver.get("http://automation.techleadacademy.io/?#/iframes");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println(js.executeScript("return document.title"));
//        WebElement homeBtn = driver.findElement(By.linkText("Home"));
//        js.executeScript("arguments[0].click();", homeBtn);

            Thread.sleep(4000);
            driver.close();
//        Actions action = new Actions(driver);
//        driver.get("https://www.etsy.com/");
//        List<WebElement> icon = driver.findElements(By.xpath("//span[@class='etsy-icon']"));
//        action.moveToElement(icon.get(1)).perform();
//        WebElement name = driver.findElement(By.xpath("//span[@role='tooltip']"));
//        System.out.println(name.getText());
    }

    public static void highlightElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        boolean highLighted = false;

        for(int i = 0; i<3; i++){
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            if(!highLighted){
                js.executeScript("arguments[0].style.backgroundColor='yellow';", element);
                highLighted = true;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                js.executeScript("arguments[0].style.backgroundColor='red';", element);
                highLighted = false;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
