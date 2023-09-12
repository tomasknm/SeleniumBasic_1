import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class semaforTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/semafor.php";

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }
    @Test
    public void Test(){
        String expectedRed = "rgb(205, 58, 63)";
        String expectedOrange = "rgb(191, 111, 7)";
        String expectedGreen = "rgb(10, 129, 0)";

        WebElement trafficLight = driver.findElement(By.xpath("/html/body/div/div"));
        String actualRed = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedRed,actualRed);

        Actions actions = new Actions(driver);
        actions.moveToElement(trafficLight).build().perform();
        String actualGreen = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen,actualGreen);

        actions.moveToElement(trafficLight).clickAndHold(trafficLight).build().perform();
        String actualOrange = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange,actualOrange);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
