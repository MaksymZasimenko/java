import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day11Frame {
    public static void main(String[] args) throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.amctheatres.com/");
//STEP 2: Print out Welcome text
        System.out.println(driver.findElement(By.xpath("//div[@class='onboarding-tour-modal']/h5")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@class='onboarding-tour-modal']/p")).getText());
//STEP 3: Click "Let's Go" option of pop-up window
        driver.findElement(By.xpath("//button[@class='Btn Btn--Primary']")).click();
//STEP 4: Print out text of pop-up window "Get More with..."
        System.out.println();
        System.out.println(driver.findElement(By.className("tourtip__header")).getText());
        System.out.println(driver.findElement(By.className("tourtip__content")).getText());
//STEP 5: Close pop-up window
        driver.findElement(By.xpath("//button[@type='button']")).click();
//STEP 6: Skipped
//STEP 7: Click all the following buttons to open in new pages: FB, Youtube, Twitter, Instagram, Pinterest
        List<WebElement> socialLinks = driver.findElements(By.xpath("//div[@class='SiteFooter-social']//li"));
        for(WebElement e: socialLinks){
            e.click();
        }
//Storing main page's ID
        String mainWindowID = driver.getWindowHandle();
//STEP 8: Print out sections in each of above websites
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String windowID: allWindowIDs){
            driver.switchTo().window(windowID);
            List<WebElement> links = new ArrayList<>();
            switch (driver.getTitle()){
                case "AMC Theatres (@amctheatres) • Instagram photos and videos":
                    links = driver.findElements(By.xpath("//li[@class='Y8-fY ']"));
                    System.out.println("\nInstagram Page:");
                    break;
                case "AMC Theatres (@AMCTheatres) / Twitter":
                    links = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz r-1w6e6rj']/div"));
                    System.out.println("\n Twitter Page:");
                    break;
                case "AMC Theatres - YouTube":
                    links = driver.findElements(By.id("subscriber-count"));
                    System.out.println("\n Youtube Page:");
                    break;
                case "AMC Theatres (amctheatres) - Profile | Pinterest":
                    List<WebElement> list1 = driver.findElements(By.xpath("//span[@class='tBJ dyH iFc yTZ pBj DrD mWe']"));
                    List<WebElement> list2 = driver.findElements(By.xpath("//span[@class='tBJ dyH iFc yTZ pBj DrD swG']"));
                    System.out.println("\n Pinterest Page:");
                    for(int i = 0; i< list1.size(); i++){
                        System.out.println(list1.get(i).getText() + " " + list2.get(i).getText());
                    }
                    break;
                case "AMC Theatres - movie times, movie trailers, buy tickets and gift cards.":
                    break;
                default:
                    links = driver.findElements(By.xpath("//div[@class='_4-u2 _6590 _3xaf _4-u8']//div[@class='_4bl9']"));
                    System.out.println("\nFacebook Page:");
            }
            if (links.size() != 0) {
                for (WebElement e : links) {
                    System.out.println(e.getText());
                }
                links = null;
            }
        }
//STEP 9a: In main page: Click "Showtimes"
        driver.switchTo().window(mainWindowID);
        driver.findElement(By.xpath("//span[@class='Showtimes-label']")).click();
//STEP 9b: Print out displayed location (Skip, not needed)
//STEP 9c: Click X button to close
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='icon icon_close']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='icon_close']")).click();
//STEP 9d: Print out the text of pop-up window
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@class='GenericModal']/p")).getText());
//STEP 9e: Click "Yes" option
        driver.findElement(By.xpath("//button[text()='Yes']")).click();
//STEP 10: Close all windows
        Thread.sleep(2000);
        driver.quit();


    }
}
//    Open https://www.amctheatres.com/
//        2. Print out main text of Welcome! pop-up window
//        3. Click "Let's Go!" option of pop-up window
//        4. Print out text of pop-up window "Get More with AMC Stubs"
//        5. Close the pop-up
//        6. Close the pop-up (didn’t appear, so skip)
//        7. Click all following buttons to open new pages:
//        - Facebook
//        - Twitter
//        - Youtube
//        - Instagram
//        - Pinterest
//        8. Print out specific section of each following websites:
//        a. Pinterest -> 8k followers | 1,8k following
//        b. Instagram -> 7,550 posts | 524k followers | 2,300 following
//        c. Youtube -> 440k subscribers
//        d. Twitter -> 39.4K Following | 442.2K Followers
//        e. Facebook (in Community section) ->
//        6,386,038 people like this | 6,171,856 people follow this
//        9. In main AMC page:
//        a. Click "Showtimes"
//        b. print out displayed location
//        c. Click X button to close
//        d. print out text of pop-up window
//        3. Click in Yes option
//        10. Close driver