import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertThat;

public class XpathTest {
    private WebDriver driver;private final String BASE_URL = "http://localhost/registracia.php";
    private final String EMAIL = "tomasknm@azet.sk";
    private final String NAME = "Tomas";
    private final String SURNAME = "Maruniak";
    private final String PASSWORD = "123";
    private final String PASSWORD_REPEAT = "123";

    @Before
        public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys(EMAIL);  // absolutny Xpath
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys(NAME);    // absolutny Xpath
        driver.findElement(By.xpath("//form/div[3]/input")).sendKeys(SURNAME);   // relativny Xpath = //cesta/cesta
        driver.findElement(By.xpath("/html/body/div/div/form/div[4]/input")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("/html/body/div/div/form/div[5]/input")).sendKeys(PASSWORD_REPEAT);
        driver.findElement(By.tagName("button")).click();
        //assert(driver.findElement(By.className("div.container alert-success")).isDisplayed());



    }

    @After
    public void tearDown(){
     //   driver.quit();
    }
}
