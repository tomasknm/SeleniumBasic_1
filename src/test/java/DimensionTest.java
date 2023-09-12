import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DimensionTest {
    public WebDriver driver;
    private String BASE_URL = "http://localhost/moveme.php";


    @Before
    public void setUp(){
    driver = new FirefoxDriver();
    }

    @Test
    public void Test(){
        driver.get(BASE_URL);
        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(-150,-150));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@id='donald']")).isDisplayed());
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
