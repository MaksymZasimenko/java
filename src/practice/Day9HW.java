package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Day9HW {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //STEP 1
        driver.get("https://www.saucedemo.com");
        //STEP 2 log in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //STEP 3 print out selected option
        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        List<WebElement> options = driver.findElements(By.xpath("//select[@class='product_sort_container']"));
        for (WebElement element : options) {
            System.out.println(element.getText());
        }
        //STEP 4 select Price low to high and print it
        select.selectByValue("lohi");
        System.out.println(select.getFirstSelectedOption().getText());
        //STEP 5 verify prices are actually sorted from low to high
        //Find out all the elements and store it inside a List
        List<WebElement> listOfPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        /*for(int i = 0; i<listOfPreces.size(); i++){

       }
    */
        //store those elements inside String arrayList
        ArrayList<String> prices = new ArrayList<>();
        for (int i = 0; i<listOfPrices.size(); i++){
            prices.add(listOfPrices.get(i).getText());
        }
        //Delete $ sign in front of each element
        ArrayList<String> prices1 = new ArrayList<>();
        for (int i = 0; i<listOfPrices.size(); i++){
            String str = prices.get(i);
            String str1 = str.substring(1);
            prices1.add(str1);
        }
        System.out.println(prices1);
        //convert String value to double
        ArrayList<Double> dblList = new ArrayList<>();
        for(int i=0; i<listOfPrices.size(); i++){
            double dbl = Double.parseDouble(prices1.get(i));
            dblList.add(dbl);
        }
        System.out.println(dblList);
        //compare the values
        for(int i=0; i<dblList.size(); i++){
            if(dblList.get(i) < 0 && dblList.get(i)>dblList.get(i+1)){
                System.out.println("Test fail");
            } else {
                System.out.println("Test pass");
            }
        }

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.close();
    }
}
