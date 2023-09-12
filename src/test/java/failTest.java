import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.fail;

public class failTest {
    private WebDriver driver;
    String BASE_URL = "http://localhost/vybersi.php";
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @Test
    public void Test() throws IOException {
        try {
            new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Charmander");
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'pokemon')]/h3"))
                    .getText().contains("Pikachu"));
        }
        catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @After
        public void tearDown() throws IOException {
        String verificationErrorsString = verificationErrors.toString();
        if (!"".equals(verificationErrorsString)) {
            File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenShot,new File("D://tmp//screenshot.png"));
            System.out.println(verificationErrorsString);
//            System.out.println(driver.getPageSource());
        }
        driver.quit();
    }
}
