package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day5Homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        List<WebElement> names = driver.findElements(By.cssSelector("a.product-name"));
        List<WebElement> prices = driver.findElements(By.cssSelector("span[class='price product-price']"));
        int count = 1;
        for(int i = 0; i < 7; i++){
            System.out.println(names.get(i).getText() + " | " + prices.get(count).getText());
            count += 2;
        }
        names.get(0).click();
        Thread.sleep(2000);
        WebElement item = driver.findElement(By.cssSelector("input#quantity_wanted"));
        item.clear();
        item.sendKeys("5");
        driver.findElement(By.cssSelector("button.exclusive")).click();
        Thread.sleep(2000);
        String expectedProductPrice = driver.findElement(By.cssSelector("span[class='ajax_block_products_total']")).getText();
        String expectedShippingPrice = driver.findElement(By.cssSelector("span[class='ajax_cart_shipping_cost']")).getText();
        String expectedTotalPrice = driver.findElement(By.cssSelector("span[class='ajax_block_cart_total']")).getText();
        System.out.println();
        System.out.println("Product price: " + expectedProductPrice);
        System.out.println("Shipping price: " + expectedShippingPrice);
        System.out.println("Total price: " + expectedTotalPrice);
        System.out.println();
        driver.findElement(By.cssSelector("a[class='btn btn-default button button-medium']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("td.cart_description")).getText());
        String actualProductPrice = driver.findElement(By.cssSelector("td#total_product")).getText();
        String actualShippingPrice = driver.findElement(By.cssSelector("td#total_shipping")).getText();
        String actualTotalPrice = driver.findElement(By.cssSelector("td#total_price_without_tax")).getText();
        System.out.println("current product price: " + actualProductPrice + " | previous " + expectedProductPrice);
        System.out.println("current shipping price: " + actualShippingPrice + " | previous " + expectedShippingPrice);
        System.out.println("current total price: " + actualTotalPrice + " | previous " + expectedTotalPrice);
        Thread.sleep(3000);
        driver.close();
    }
}
