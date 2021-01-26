import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4 {
    public static void main(String[] args) throws  InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io");

        WebElement inputs = driver.findElement(By.partialLinkText("Inputs"));
        inputs.click();

        WebElement enterMessage = driver.findElement((By.id("message")));
        enterMessage.sendKeys("TLA");
        enterMessage.submit();

      if(driver.findElement(By.name("message1")).getText().equals("TLA")){ // verify if input is same with the output
          System.out.println("same");
      } else {
          System.out.println("not same");
      }


        String numberA = "3";
        String numberB = "8";

      WebElement enterNumA = driver.findElement(By.id("a"));
      enterNumA.sendKeys("3");

      WebElement enterNumB = driver.findElement(By.id("b"));
      enterNumB.sendKeys("8");

      WebElement getTotal = driver.findElement(By.name("button2"));
      getTotal.click();

      String res = driver.findElement(By.name("answer2")).getText();


      int a = Integer.parseInt(res);
      int numA = Integer.parseInt(numberA);
      int numB = Integer.parseInt(numberB);

      if(a == numA+numB){
          System.out.println("true");
      }else{
          System.out.println("false");
      }


        driver.findElement(By.name("first_name")).sendKeys("Maksym");
        driver.findElement(By.name("last_name")).sendKeys("Zasimenko");
        driver.findElement(By.name("email")).sendKeys("max@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("8880908888");
        driver.findElement(By.name("address")).sendKeys("1 main st");
        driver.findElement(By.name("city")).sendKeys("Washington");
        driver.findElement(By.name("state")).sendKeys("Maryland");
        driver.findElement(By.name("zip")).sendKeys("20001");

        driver.findElement(By.name("button3")).click();

        if(driver.findElement(By.name("answer3")).getText().equals("Thanks for contacting us, we will get back to you shortly.")){
            System.out.println("passed");
        }else{
            System.out.println("not passed");
        }

        Thread.sleep(2000);
        driver.close();



    }
}
