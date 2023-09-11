import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

public class ColourTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/stroopeffect.php";


    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }
    @Test
    public void Test(){

        // driver.findElement(By.xpath("//div[contains(@class, 'colours')]/h1[1]")).getCssValue("color");
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        List<String> receivedColors = new ArrayList<>();
        List<String> expectedColors = new ArrayList<>();
        expectedColors.add("#ff0e0e");
        expectedColors.add("#058006");
        expectedColors.add("#12fcff");
        expectedColors.add("#ffbb43");
        expectedColors.add("#ff46d9");

        for (WebElement title : titles) {
            String hexColor = org.openqa.selenium.support.Color.fromString(title.getCssValue("color")).asHex();
            receivedColors.add(hexColor);
        }

        for (int i = 1; i < expectedColors.size()+1; i++) {
            Assert.assertEquals(expectedColors,receivedColors);
        }
    }
    @After
    public void tearDown(){
        driver.quit();

    }
}
