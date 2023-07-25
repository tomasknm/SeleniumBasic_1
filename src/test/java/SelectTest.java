import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {
    private WebDriver driver;
    private String BASE_URL = "http://localhost/vybersi.php";



    @Before
    public void setUp() { driver = new FirefoxDriver();}

    @Test
    public void test() {
        driver.get(BASE_URL);
        String[] strAr = {"0","I choose you Charmander !","I choose you Bulbasaur !","xxxI choose you Squirtle !","I choose you Pikachu !","I choose you Diglett !","I choose you Geodude !"};
        for (int i = 1; i < strAr.length; i++) {
            if  (i == 0) {
                Assert.assertFalse(driver.findElement(By.xpath("//div[2]/h3")).isSelected());
            }
            new Select(driver.findElement(By.className("form-control"))).selectByIndex(i);
            Assert.assertEquals("String message: " + (i) + " was not found",strAr[i],driver.findElement(By.xpath("//div[2]/h3")).getText());
        }
        //new Select(driver.findElement(By.className("form-control"))).selectByValue("02");
        //new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Geodude");
    }
    @After
    public void tearDdown() {
        driver.quit();
    }

}
