import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BackwardForwardTest {
    String BASE_URL = "http://localhost/registracia.php";
    WebDriver driver = new FirefoxDriver();


    @Before
    public void setUp() {
        driver.get(BASE_URL);
    }

    @Test
    public void Test() {
        String email = "email@test.sk";
        driver.findElement(By.xpath("//form/div[1]/input")).sendKeys(email);
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();

        driver.navigate().back();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/div[1]/input"))) ;
        driver.findElement(By.xpath("//form/div[1]/input")).getText();
        Assert.assertEquals(email,driver.findElement(By.name("email")).getAttribute("value"));

        driver.navigate().forward();
        new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());

    }

    @After
    public void terrDown() {
        //driver.quit();

    }


}
