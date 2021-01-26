import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class Day6 {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Navigate to the websit
//        driver.get("https://www.zillow.com/");
//        //Print out names of links in Footer section
//        List<WebElement> elementList = driver.findElements(By.cssSelector("ul[class='pfs__sc-1kahb5i-0 ejTrQc']"));
//        for(int i = 0; i < elementList.size(); i++){
//            System.out.println(elementList.get(i).getText());
//        }
//        //click Buy button
//        driver.findElement(By.cssSelector("a[class='Anchor-hn4bge-0 pfs__sc-1dpbk03-0 icabtx noroute']")).click();
//        //Input Fairfax
//        WebElement inputBar = driver.findElement(By.cssSelector("input[class='react-autosuggest__input']"));
//        inputBar.clear();
//        inputBar.sendKeys("Fairfax, VA");
//        //click SaveSearch
//        driver.findElement(By.cssSelector("button[class$='save-search-button']")).click();
//        System.out.println("----");
//        //Printout almost done
//        System.out.println(driver.findElement(By.cssSelector("h2[class='auth-heading']")).getText());
//        System.out.println("-----");
//        //Printout the links
//        System.out.println(driver.findElement(By.cssSelector("button[class='btn-social-connect btn-apple']")).getText());
//        System.out.println(driver.findElement(By.cssSelector("button[class='btn-social-connect btn-facebook zsg-button_primary']")).getText());
//        System.out.println(driver.findElement(By.cssSelector("button[class='btn-social-connect btn-google-plus google-plus-logo']")).getText());
//

        //Second assignment
//        driver.get("http://automation.techleadacademy.io/#/home");
//        driver.findElement(By.cssSelector("a[href='#/selectors']")).click();
//
//        List<WebElement> childClass = driver.findElements(By.cssSelector("div[id=parent2]>div[class^='child']"));
//            for(WebElement element : childClass){
//                String str = element.getText();
//                System.out.println(str);
//            }

        //Find Lamborghini models
        driver.get("http://automation.techleadacademy.io/#/home");
        driver.findElement(By.cssSelector("a[href='#/selectors']")).click();
        List<WebElement> lambo = driver.findElements(By.cssSelector("div[id='lamborghini']>div>div:nth-child(1)>div"));
        for(int i = 1; i < lambo.size(); i++){
            System.out.println("    - "+lambo.get(i).getText());
        }


        System.out.println("---------");
        //Porche
        //Find compact models
        List<WebElement> porcheCompact = driver.findElements(By.cssSelector("div[id='porsche']>div>div:nth-child(1)>div"));
        System.out.println("1) "+porcheCompact.get(0).getText());
        for(int i = 1; i < porcheCompact.size()-2; i++){
            System.out.println("    - "+porcheCompact.get(i).getText());
        }

        //Find mid-size models
        List<WebElement> porcheMidSize = driver.findElements(By.cssSelector("div[id='porsche']>div>div:nth-child(2)>div"));
        System.out.println("2) "+porcheMidSize.get(0).getText());
        System.out.println("    - "+porcheMidSize.get(2).getText());


        System.out.println("--------");
        //Mercedes
        //Find GLA-class
        List<WebElement> mercedesGLA = driver.findElements(By.cssSelector("div[id='mercedes']>div>div:nth-child(4)>div"));
        System.out.println("    - "+mercedesGLA.get(2).getText());

        //Find C-class
        List<WebElement> mercedesC = driver.findElements(By.cssSelector("div[id='mercedes']>div>div:nth-child(2)>div"));
        System.out.println("    - "+mercedesC.get(2).getText());

        driver.close();
    }
}