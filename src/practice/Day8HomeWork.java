package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Day8HomeWork {
    public static void main(String[] args) {

        //STEP 1 create a Arraylist of elements
        ArrayList<String> ls = new ArrayList<>();
        ls.add("Maksym");
        ls.add("Zasimenko");
        ls.add("test@gmail.com");
        ls.add("2022022002");
        ls.add("1 st NW");
        ls.add("Washington");
        ls.add("District of Columbia");
        ls.add("20002");

        System.out.println(ls);

        //STEP 2 go to the target website
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io");

        //STEP 3 go to inputs
        driver.findElement(By.xpath("//a[contains(text(),'Inputs')]")).click();

        //STEP 4 fill out required section

//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(ls.get(0));
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(ls.get(1));
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ls.get(2));
//        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(ls.get(3));
//        driver.findElement(By.xpath("//input[@name='address']")).sendKeys(ls.get(4));
//        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(ls.get(5));
//        driver.findElement(By.xpath("//select[@name='state']")).sendKeys(ls.get(6));
//        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(ls.get(7));


        //STEP 5 click sumbit
        driver.findElement(By.xpath("//button[@name='button3']")).click();

        //STEP 6 verify text
        System.out.println(driver.findElement(By.xpath("//div[@name='answer3']")).getText());

       try{
           Thread.sleep(2000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }

       driver.close();
//
//        String[] array = {"First name", "Last name", "email", "phone number", "address", "city", "Virginia", "zip code"};
//        driver.get("http://automation.techleadacademy.io");
//        driver.findElement(By.xpath("//a[text()='Inputs']")).click();
//        List<WebElement> inputFields = driver.findElements(By.xpath("//input[@name]"));
//        for(int i = 0; i < inputFields.size(); i++){
//            if (i != 6){
//                inputFields.get(i).sendKeys(array[i]);
//            }else{
//                driver.findElement(By.xpath("//select[@name]")).sendKeys(array[i]);
//                inputFields.get(i).sendKeys(array[i + 1]);
//            }
//        }
//        driver.findElement(By.xpath("//button[@name='button3']")).click();
//        System.out.println(driver.findElement(By.xpath("//div[@name='answer3']")).getText().equals("Thanks for contacting us, we will get back to you shortly."));
//

    }
}
