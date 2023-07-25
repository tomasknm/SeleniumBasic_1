import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {
    private String BASE_URL = "http://localhost/redalert.php";
    private WebDriver driver;

    @Before
    public void setUp() {
        driver= new FirefoxDriver();
        driver.get(BASE_URL);

        // Alert 1 tets //////
        driver.findElement(By.id("alert1")).click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div/div/div/h1")).getText().contains("Kirov Reporting"));

        // Alert 2 test //////
        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        Assert.assertTrue(driver.findElement(By.xpath("//div/div/div/h1")).getText().contains("Negative"));


        // Allert 3 test /////
        String NAME = "Danko";
        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys(NAME);
        alert3.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div/div/div/h1")).getText().contains(NAME));
    }
    @Test

    @After
    public void tearDown() {

    }
}