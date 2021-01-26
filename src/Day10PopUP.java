import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day10PopUP {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automation.techleadacademy.io/#/popup");

        driver.findElement(By.id("bmi_btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("feet")).sendKeys("5");
        driver.findElement(By.name("inch")).sendKeys("10");
        driver.findElement(By.name("weight")).sendKeys("170");
        driver.findElement(By.id("calculate_btn")).click();
        Thread.sleep(2000);
        String value = driver.findElement(By.id("BMI_result")).getText();
        double value1 = Double.parseDouble(value);
        System.out.println(value);
        String category = "";
        if (value1<18.5){
            category = "Underweight";
        }else if (value1<25){
            category = "Normal weight";
        }else if (value1<30){
            category = "Overweight";
        }else {
            category = "Obese";
        }
        switch (category){
            case "Underweight":
                System.out.println("Underweight");
                break;
            case "Normal weight":
                System.out.println("Normal weight");
                break;
            case "Overweight":
                System.out.println("Overweight");
                break;
            case "Obese":
                System.out.println("Obese");
                break;
            default:
                System.out.println("Unrecognized category");
        }
    }
}
