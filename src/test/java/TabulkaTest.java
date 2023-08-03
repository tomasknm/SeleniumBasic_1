import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TabulkaTest {
    private final String BASE_URL = "http://localhost/tabulka.php";
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows + 1; i++) {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i +"]")).getText());
            Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]")).getText().isEmpty());
        }
    }
    @Test

    @After
    public void tearDown() {
        driver.quit();
    }

}
