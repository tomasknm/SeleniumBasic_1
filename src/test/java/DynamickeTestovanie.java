import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamickeTestovanie {
    private WebDriver driver;
    String BASE_URL="http://localhost/zjavenie.php";


    @Before
    public void setDriver() {driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }
    @Test
    public void Test() throws InterruptedException   {
        driver.findElement(By.id("showHim")).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions                       //visibility
                        .visibilityOfElementLocated(By.xpath("//img[@class='brano']")));
        new WebDriverWait(driver, Duration.ofSeconds(5))        //presence
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='brano']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
