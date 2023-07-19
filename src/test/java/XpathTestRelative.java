import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathTestRelative {
    private WebDriver driver;private final String BASE_URL = "http://localhost/xpathtrainingcenter.php";


    @Before
        public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//div[2]/div/div/select[1]/option[2]")).click();
        driver.findElement(By.xpath("//div[2]/div[1]/div[1]/select[2]/option[3]")).click();
        driver.findElement(By.xpath("//DIV[1]/BUTTON[6]")).click();
//        driver.findElement(By.xpath("//DIV[@class='MENOTRIEDY']")).click();   pomocou mena triedy
//        driver.findElement(By.xpath("button[text()='nejakytext']")).click();  pomocou textu






    }

    @After
    public void tearDown(){
     //   driver.quit();
    }
}
