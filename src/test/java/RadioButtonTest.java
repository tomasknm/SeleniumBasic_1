import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost/zenaalebomuz.php";
    int testCase = 0;

    @Before
    public void setUp() {driver = new FirefoxDriver();}

    @Test
    public void Test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//div/label[1]/input")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText().contains("wurst"));
        Assert.assertFalse((driver.findElement(By.xpath("/html/body/div/h1")).isSelected()));
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
