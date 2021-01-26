package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class MultipleWIndowsPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/multiplewindow");

        //Stroing ID of the current window so I will be able to return later after switching to the other window
        String currentWindow = driver.getWindowHandle();

        //Printing out values of the 3 buttons
        List<WebElement> buttons = driver.findElements(By.xpath("//div/a"));
        buttons.forEach(a-> System.out.println(a.getText()));

        driver.findElement(By.xpath("//a[text()='Launch Facebook']")).click();

        //Storing all window ID's  in a Set
        Set<String> allWindows = driver.getWindowHandles();
        for(String window: allWindows){
            if(!window.equals(currentWindow))
                driver.switchTo().window(window);
        }

        //Printing text in FB
        System.out.println(driver.findElement(By.className("_8eso")).getText());
        driver.close();

        //switching back to main window
        driver.switchTo().window(currentWindow);

        //opening Google page
        driver.findElement(By.linkText("Launch Google")).click();

        //capturing all window ID's again
        allWindows = driver.getWindowHandles();

        //switching to Google page
        for(String window : allWindows){
            if(!window.equals(currentWindow))
                driver.switchTo().window(window);
        }

        //getting title
        System.out.println(driver.getTitle());

        //closing all
        driver.quit();

//        1. open http://automation.techleadacademy.io/#/multiplewindow
//        2. print out 3 text of 3 buttons
//        3. open Facebook link
//        4. pring out "Connect with friend and the world..." text
//        5. Close facebook window
//        6. return to main window (tla practice website)
//        7. open Google link
//        8. print out title of the Google page
    }

}
