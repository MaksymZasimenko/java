package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import  java.util.concurrent.TimeUnit;

public class Orbitz {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orbitz.com");


        //Type destination
        driver.findElement(By.xpath("//button[@aria-label='Going to']")).sendKeys("Las Vegas, Nevada");
        Thread.sleep(2000);
        //Select destination
        driver.findElement(By.xpath("//button[@data-stid='location-field-destination-result-item-button' ]")).click();
        Thread.sleep(2000);


        //Select number of guests and rooms
       driver.findElement(By.xpath("//button[@class='uitk-fake-input uitk-form-field-trigger']")).click();
        //Add extra room
       driver.findElement(By.xpath("//button[@data-testid='add-room-button']")).click();
       //Add adults & children
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-step-input-button']"));
        buttons.get(3).click();
        buttons.get(3).click();
        buttons.get(5).click();
        //Add children age
        driver.findElement(By.id("child-age-input-0-0")).sendKeys("2");
        driver.findElement(By.id("child-age-input-0-1")).sendKeys("4");
        //Submit
        driver.findElement(By.xpath("//button[@data-testid='guests-done-button']")).click();
        //Submit search
        driver.findElement(By.xpath("//button[@data-testid='submit-button']")).click();

        //Scroll down to see all the hotels
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i = 0; i <=4; i++){
            js.executeScript("window.scrollBy(0,2000)","");
        }
        //Capture all hotel Names
        List<WebElement> hotelNames = driver.findElements(By.xpath("//div[@class='uitk-grid all-cell-fill all-cell-align-top']"));
        for (WebElement element:hotelNames){
            System.out.println(element.getText());
        }
        System.out.println("---------");
        //MAPS
        List<WebElement> rating = driver.findElements(By.xpath("//span[@class='uitk-type-300 uitk-type-bold all-r-padding-one']"));
        List<WebElement> namesWithDisc = driver.findElements(By.xpath("(//span[@class='uitk-badge-text'][contains(text() , '% off')])/parent::span/parent::div/parent::div/parent::div/parent::div/parent::div//div//h3"));
        List<WebElement> discounted = driver.findElements(By.xpath("//span[@class='uitk-badge-text'][contains(text() , '% off')]"));
        List<WebElement> more100 = driver.findElements(By.xpath("//span[@class='uitk-cell loyalty-display-price all-cell-shrink']//span[@class='uitk-cell loyalty-display-price all-cell-shrink']"));

        Map<String, Double> namesAndRating = new LinkedHashMap<>();
        Map<String, Integer> namesAndDisc = new LinkedHashMap<>();
        Map<String, Integer> namesAndMore = new LinkedHashMap<>();

       //By rating
        for(int i = 0; i<rating.size(); i++){
            if(Double.parseDouble(rating.get(i).getText().substring(0,3)) >= 4.5)
                namesAndRating.put(hotelNames.get(i).getText(), Double.parseDouble(rating.get(i).getText().substring(0,3)));
        }
        for(Map.Entry<String, Double> entry:namesAndRating.entrySet()){
           if(entry.getValue()>=4.5){
               System.out.println(entry.getKey()+"-"+entry.getValue());
            }
        }
        System.out.println("---------");
        Thread.sleep(1000);

        //By price
        for (int i = 0; i<more100.size(); i++){
            if(more100.get(i).getText().replace("$", "").length() >= 3 && Integer.parseInt(more100.get(i).getText().substring(1)) > 100){
                namesAndMore.put(hotelNames.get(i).getText(), Integer.parseInt(more100.get(i).getText().substring(1)));
            }
        }
        for (Map.Entry<String, Integer> entry : namesAndMore.entrySet()){
            if(entry.getValue()>=100){
                System.out.println(entry.getKey()+"-"+entry.getValue());
            }
        }

        System.out.println("--------");
        Thread.sleep(1000);
        //By discount
        for(int i =0; i<discounted.size();i++){
            if(discounted.get(i).getText().startsWith("We") && Integer.parseInt(discounted.get(i).getText().substring(18, 20))>= 20){
                namesAndDisc.put(namesWithDisc.get(i).getText(), Integer.parseInt(discounted.get(i).getText().substring(18, 20)));
            }else if(!discounted.get(i).getText().startsWith("We") && Integer.parseInt(discounted.get(i).getText().substring(0, 2))>=20){
                namesAndDisc.put(namesWithDisc.get(i).getText(), Integer.parseInt(discounted.get(i).getText().substring(0, 2)));
            }
        }
        for (Map.Entry<String, Integer> entry: namesAndDisc.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
        System.out.println("-----");
        Thread.sleep(1000);
        //Hotels that have 20%+, cost $100+, rating is 4.5+
        for(int i =0; i<discounted.size(); i++){
            if(discounted.get(i).getText().startsWith("We") && Integer.parseInt(discounted.get(i).getText().substring(18,20))>=20 &&
            more100.get(i).getText().replace("$", "").length()>=3 && Integer.parseInt(more100.get(i).getText().substring(1))>100 &&
            Double.parseDouble(rating.get(i).getText().substring(0, 3))>=4.5){

                System.out.println(namesWithDisc.get(i).getText()+"-"+
                        more100.get(i).getText()+"-"+rating.get(i).getText()+"-"+discounted.get(i).getText());

            }else if(!discounted.get(i).getText().startsWith("We") && Integer.parseInt(discounted.get(i).getText().substring(0,2))>=20 &&
                    more100.get(i).getText().replace("$", "").length()>=3 && Integer.parseInt(more100.get(i).getText().substring(1))>100 &&
                    Double.parseDouble(rating.get(i).getText().substring(0, 3))>=4.5){

                        System.out.println(namesWithDisc.get(i).getText()+"-"+
                                more100.get(i).getText()+"-"+rating.get(i).getText()+"-"+discounted.get(i).getText());
            }
        }
        Thread.sleep(2000);
        driver.close();
    }
}
