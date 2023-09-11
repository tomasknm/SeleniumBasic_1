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
import java.util.logging.FileHandler;

public class RefreshTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void Test() {
        driver.get(BASE_URL);
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());

        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("clicks"))).isDisplayed();
        Assert.assertEquals("0",driver.findElement(By.id("clicks")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
