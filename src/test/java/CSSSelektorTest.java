import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CSSSelektorTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/kalkulacka.php";



    @Before
        public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("button#count")).click();                 // tag#ID
        driver.findElement(By.cssSelector("button.btn-danger")).click();                    // tag.class
        driver.findElement(By.cssSelector("div.container input")).sendKeys("ahoj1");  // tag.class element .. nepriame dieta
        driver.findElement(By.cssSelector("div.has-error>input")).sendKeys("ahoj2");  // tag.class>element .. priame dieta




    }

    @After
    public void tearDown(){
     //   driver.quit();
    }
}
