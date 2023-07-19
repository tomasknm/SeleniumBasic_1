import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickMeTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/clickmebaby.php";

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get(BASE_URL);
        //Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());
        for (int j = 0; j < 11; j++) {
            Assert.assertEquals("Ocakavany pocet klikov:", String.valueOf(j), driver.findElement(By.id("clicks")).getText());
            driver.findElement(By.xpath("//button")).click();
        }
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}





