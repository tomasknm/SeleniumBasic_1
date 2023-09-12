import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class TitleTest {
    private WebDriver driver;
    private final String BASE_URL= "http://localhost";


    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }


    @Test
    public void Test(){
        List<WebElement> pages = driver.findElements(By.xpath("//nav/div/ul/li/a"));
        List<String> pageUrls = new ArrayList<>();


        for (WebElement page : pages) {
            pageUrls.add(page.getAttribute("href"));
        }
        for (String pageUrl : pageUrls) {
            driver.get(pageUrl);
            String exectedTitle = pageUrl.substring(pageUrl.lastIndexOf("/")+1,pageUrl.indexOf(".php"));
            String currentTitle = driver.getTitle().substring(10);
            System.out.println(currentTitle);
            Assert.assertEquals(exectedTitle.substring(0,1).toUpperCase() + exectedTitle.substring(1),currentTitle);
            }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
