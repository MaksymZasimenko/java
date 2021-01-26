import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day15 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //STEP 1: Open the website
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
//STEP 2: Click on M Size
        driver.findElement(By.xpath("//span[text()='M']")).click();
//STEP3: Verify there is only one item displayed
        Thread.sleep(500);
        List<WebElement> mSizeShirts = driver.findElements(By.xpath("//div[@class='shelf-container']/div[@class='shelf-item']"));
        System.out.print("is there only 1 item? - ");
        System.out.println(mSizeShirts.size() == 1);
        System.out.println("----------------");
//STEP 4: Unclick on M size and click XXL size
        driver.findElement(By.xpath("//span[text()='M']")).click();
        driver.findElement(By.xpath("//span[text()='XXL']")).click();
        Thread.sleep(500);
//STEP 5: Print out all elements in the following format: Name + price
        List<WebElement> allSizeShirts = driver.findElements(By.xpath("//div[@class='shelf-container']/div[@class='shelf-item']"));
//Created an array so i can use in step 7
        String[] names = new String[4];
        int index = 0;
        for (WebElement element: allSizeShirts){
            String name = element.findElement(By.xpath("./p")).getText();
            String price = element.findElement(By.xpath(".//div[@class='val']")).getText();
            System.out.println(name + " - " + price);
            //adding each name to an array so i can use it in step 7
            names[index] = name;
            index++;
        }
//STEP 6: Add all 4 items to Cart
        for (WebElement element: allSizeShirts){
            element.click();
        }
//STEP 7: Verify cart section has all 4 items added based on names
        System.out.println(" --------------  ");
        Thread.sleep(500);
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='float-cart__shelf-container']//p[@class='title']"));
//Negative scenario: changing item name in the array
//names[3] = "Apple";
        for (String eachName: names){
            boolean contains = false;
            for (WebElement element: cartItems){
                if (eachName.equals(element.getText()))
                    contains = true;
            }
            if (!contains) {
                System.out.println(eachName + " - was not found in the cart list");
            }else {
                System.out.println(eachName + " - was part of the items in the cart");
            }
        }
        System.out.println("----------");
//STEP 8: Select lowest to highest
//        Select select = new Select(driver.findElement(By.xpath("//select")));
//        select.selectByValue("lowestprice");
//STEP 9: Verify all prices are sorted from lowest to highest
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='shelf-container']//div[@class='val']"));
        for (int i = 0; i < prices.size()-1; i++){
            System.out.println(Double.parseDouble(prices.get(i).getText().substring(1)) + " - " + Double.parseDouble(prices.get(i+1).getText().substring(1)));
            if (Double.parseDouble(prices.get(i).getText().substring(1)) <= Double.parseDouble(prices.get(i+1).getText().substring(1))){
                System.out.println("Matched the criteria");
            }else {
                System.out.println("Test failed");
            }
        }
//Capturing subTotal value
        String subtotalElement = driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();
//STEP 10: Click on Checkout button
        driver.findElement(By.xpath("//*[text()='Checkout']")).click();
//STEP 11: Verify pop-up window price matches to subtotal value in car
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();
        double alertPrice = Double.parseDouble(alertMsg.substring(alertMsg.indexOf("$") + 1));
        double subtotalPrice = Double.parseDouble(subtotalElement.substring(2));
        System.out.print("Subtotal price and Alert price match? - ");
        System.out.println(alertPrice == subtotalPrice);
//STEP 10: Close all windows
        Thread.sleep(2000);
        driver.quit();
    }
}
