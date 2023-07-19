import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertThat;

public class MyThirdTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/registracia.php";
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
        driver.findElement(By.className("form-control")).sendKeys(EMAIL);  // hladanie podla mena triedy
        driver.findElement(By.name("name")).sendKeys(NAME);    // hladanie podla mena
        driver.findElement(By.name("surname")).sendKeys(SURNAME);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("password-repeat")).sendKeys(PASSWORD_REPEAT);
        driver.findElement(By.tagName("button")).click();
        //assertThat(driver.findElement(By.className("alert alert-success")),
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input"));  //Xpath



    }

    @After
    public void tearDown(){
     //   driver.quit();
    }
}
