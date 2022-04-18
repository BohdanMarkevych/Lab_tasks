package lab.selenium.task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;


public class App {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().getPageLoadTimeout();
        driver.findElement(By.name("q")).sendKeys("Glasses" + Keys.ENTER);
        List<WebElement> imageList = driver.findElements(xpath("//div[@id=\"iur\"]//img[@style]"));
        for (WebElement webElement : imageList) {
            System.out.println(webElement.getAttribute("src"));
        }
        driver.quit();


    }

}
