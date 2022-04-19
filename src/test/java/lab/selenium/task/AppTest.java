package lab.selenium.task;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class AppTest {

    @Test
    public void VerifyThatImageTabContainsImages() throws IOException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Glasses" + Keys.ENTER);
        driver.manage().timeouts().getPageLoadTimeout();
        List<WebElement> imageTab = driver.findElements(xpath("//div[@id=\"iur\"]//img[@style]"));
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/screenshots/testScreenshot.png"));
        for (WebElement webElement : imageTab) {
            System.out.println(webElement.getAttribute("src"));
            assertTrue(webElement.getAttribute("src").contains("image"));
        }
        driver.quit();
    }

}




