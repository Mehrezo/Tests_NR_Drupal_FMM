import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//Ajouter par M_OU le 01/12/2014 pour le fonctionnement des tests TA server 
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
//Fin Ajout par M_OU le 01/12/2014 pour le fonctionnement des tests TA server

public class F24ExigenceHomePage {
//----------------------------------------------------------------------------
//Ajouter par M_OU le 01/12/2014 pour le fonctionnement des tests TA server 
//----------------------------------------------------------------------------
  private FirefoxBinary binary = new FirefoxBinary(new File("C:/Program Files (x86)/Mozilla Firefox12.0/firefox.exe"));
  private FirefoxProfile profile = new FirefoxProfile();
//----------------------------------------------------------------------------
//Fin Ajout par M_OU le 01/12/2014 pour le fonctionnement des tests TA server
//----------------------------------------------------------------------------
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver(); // remplacer par la ligne suivante - Modif de M_OU le 01/12 
    driver = new FirefoxDriver(binary,profile);
    
    baseUrl = "http://www.france24.open/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testF24ExigenceHomePage() throws Exception {
    driver.get(baseUrl + "fr/");
    driver.findElement(By.id("logo-image")).click();
    driver.findElement(By.linkText("2")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
