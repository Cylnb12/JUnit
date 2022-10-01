package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;

import java.time.Duration;

public class C03_AssertionOrnek3YanlisEmailTesti {
    /*  1. Bir Class olusturalim YanlisEmailTesti
        2. http://automationpractice.com/index.php sayfasina gidelim
        3. Sign in butonuna basalim
        4. Email kutusuna @isareti olmayan bir mail yazip enter’a
           bastigimizda “Invalid email address” uyarisi ciktigini test edelim*/
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='login']")).click();
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email']"));
        Thread.sleep(2000);
        emailBox.sendKeys("ixirb12gmail.com", Keys.ENTER);
        Thread.sleep(2000);
        String ExpectedSonuc = "Invalid email address.";
        String ActualSonuc = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
        Assert.assertEquals(ExpectedSonuc, ActualSonuc);

    }

}
