package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Alerts {

    @Test
    public void Test_Alerts() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        //Click Button to see alert
        driver.findElement(By.xpath("//button[text() = 'Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //On button click, alert will appear after 5 seconds
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("(//button[text() = 'Click Me'])[1]"));
            }
        });

        //On button click, confirm box will appear
        driver.findElement(By.xpath("(//button[text() = 'Click Me'])[2]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //On button click, prompt box will appear
        driver.findElement(By.xpath("(//button[text() = 'Click Me'])[3]")).click();
        driver.switchTo().alert().sendKeys("Hello, This alert has been created by me");
        driver.switchTo().alert().accept();
    }
}