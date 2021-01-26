import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day1 {

    public static void main(String[] args)  {
//        System.setProperty("webdriver.gecko.driver","C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\geckodriver.exe");

  //      WebDriver driver = new FirefoxDriver();
    //    driver.get("https://www.techleadacademy.io");

        System.setProperty("webdriver.chrome.driver","C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        long millis = 2000;
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){

        }

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.navigate().to("https:www.twitter.com");

        System.out.println(driver.getTitle());

        driver.navigate().back();
        driver.navigate().forward();

        driver.quit();
        driver.close();
    }


}

