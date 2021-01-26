import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automation.techleadacademy.io/?#/tables");

        WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));

        List<WebElement> pages = driver.findElements(By.xpath("//li[@class='page-item']"));
        for (WebElement element: pages){

            List<WebElement> age = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[4]"));
            List<WebElement> email = driver.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[6]"));

            for (int i = 0; i < age.size(); i++) {
                int ageInt = Integer.parseInt(age.get(i).getText());
                if (ageInt >= 40 && ageInt <= 50) {
                    System.out.println(ageInt + " " + email.get(i).getText());
                }
            }
            element.click();
        }


        //OPTION 1
//        WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));
//        List<WebElement> genders = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));
//        List<WebElement> names = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[1]"));
//        for(int i = 0; i < genders.size(); i++){
//            if (genders.get(i).getText().equals("Female"))
//                System.out.println(names.get(i).getText());
//        }

//        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
////        List<WebElement> gender = tableRows.get(0).findElements(By.xpath("./td"));
////        System.out.println(gender.size());
//
        //OPTION 2
//        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
//        for (WebElement row: tableRows){
//            if (row.findElement(By.xpath("./td[3]")).getText().equals("Female"))
//                System.out.println(row.findElement(By.xpath("./td[1]")).getText());
//        }
    }
}
