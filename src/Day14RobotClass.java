import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class Day14RobotClass {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zasim\\OneDrive\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        driver.get("http://automation.techleadacademy.io/?#/files");
        Thread.sleep(2000);
        WebElement upLoad = driver.findElement(By.id("exampleFormControlFile1"));
        System.out.println(upLoad.getLocation());
        Robot robot = new Robot();
        robot.mouseMove(675, 650);
        Thread.sleep(2000);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseMove(575, 470);
        Thread.sleep(2000);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseMove(575, 370);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

//        WebElement todo = driver.findElement(By.id("todo1"));
//        WebElement box = driver.findElement(By.id("div1"));
//        System.out.println(todo.getLocation());
//        System.out.println(box.getLocation());
//        Robot robot = new Robot();
//        robot.mouseMove(750, 800);
//        Thread.sleep(2000);
////        action.clickAndHold().perform();
//        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
//        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(2000);
//        robot.mouseMove(1005, 960);
//        Thread.sleep(1000);
////        action.release().perform();
//        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(3000);

        //driver.close();
    }
}
