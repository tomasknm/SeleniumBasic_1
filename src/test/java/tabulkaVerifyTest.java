// Generated by Selenium IDE
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class tabulkaVerifyTest {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void verifyTabulkaTest() {
    driver.get("http://localhost/tabulka.php");
    assertEquals("1",driver.findElement(By.xpath("//tr[1]/td")).getText());

    int rows = Integer.parseInt((driver.findElement(By.xpath("//tr[last()]/td[1]")).getText()));
    System.out.println("Pocet riadkov tabulky: " +(rows));

    for (int i = 1   ; i < rows+1; i++) {
      try {
        Assert.assertEquals(String.valueOf(i),driver.findElement(By.xpath("//tr[" + i + "]/td")).getText());
      }

      catch (Error e) {
        verificationErrors.append(e.toString());
      }
    }
  }
  @After
  public void tearDown() throws Exception {
    String verificationErrorsString = verificationErrors.toString();
    if (!"".equals(verificationErrorsString)) {
      fail(verificationErrorsString);
    }
  }
}
