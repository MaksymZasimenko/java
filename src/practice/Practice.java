package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.automationpractice.com");


        List<WebElement> dressesBtns = driver.findElements(By.className("sf-with-ul"));
        dressesBtns.get(3).click();
//-------------
        List<WebElement> element = driver.findElements(By.partialLinkText("Casual Dresses"));
        System.out.println(element.size());
        System.out.println(element.get(0).getAttribute("href"));
//----------------

        List<WebElement> element1 = driver.findElements(By.partialLinkText("Evening Dresses"));
        System.out.println(element1.size());
        System.out.println(element1.get(0).getAttribute("href"));

        List<WebElement> element2 = driver.findElements(By.partialLinkText("Summer Dresses"));
        System.out.println(element2.size());
        System.out.println(element2.get(0).getAttribute("href"));


        //----------------------

        WebElement casualDresses = driver.findElement(By.partialLinkText("Casual Dresses"));
        casualDresses.click();
        System.out.println(driver.findElement(By.className("cat-name")).getText());
        System.out.println(driver.findElement(By.className("category-name")).getText());
        //--------
        Thread.sleep(2000);
        //-------

        driver.navigate().back();
        //-----
        WebElement eveningDresses = driver.findElement(By.partialLinkText("Evening Dresses"));
        eveningDresses.click();
        System.out.println(driver.findElement(By.className("cat-name")).getText());
        System.out.println(driver.findElement(By.className("category-name")).getText());

        Thread.sleep(2000);
        driver.close();


    }

    /*
    1. Open the browser -> automationpractice.com - done

2. Click "Dresses" button - done

3. Print out value of "href" attributes of items under "Dresses" section - done

4. Then Click on "Casual dresses" - done

5. Verify "header" of that section's name is "CASUAL DRESSES"

6. Navigate back - done

7. Click on "Evening Dresses" - done

8. Print out and Verify title is "Evening Dresses - My Store"
     */
}
