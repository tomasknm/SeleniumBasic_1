import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class nemenneTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost/nemenne.php";

    @Before
    public void setUp() {driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void test() {
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value = 'Eva Mazikova']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());
        // retazenie findElement
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());
        // vyhladanie triedy v Xpath
        Assert.assertFalse(driver.findElement(By.className("btn-danger")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).isEnabled());
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
