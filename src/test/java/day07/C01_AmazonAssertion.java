package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AmazonAssertion {
    /*
    -Amazon sayfasina gidelim
    3 farkli test methodu olusturalim
        a-Url nin amazon icerdigini test edelim
        b-Title nin facebook icermedigini test edelim
        c-Sol üst kosede amazon logosunun gorundugunu test edelim.
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test1(){
        Assert.assertTrue("Url testi sonucu : ",driver.getCurrentUrl().contains("amazon"));

    }@Test
    public void test2(){
        Assert.assertFalse("Title testi Sonucu : ",driver.getTitle().contains("facebook"));

    }@Test
    public void test3(){

        WebElement amazonBox=driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
        Assert.assertTrue("Sol ust kösede amazon görüntü testi : ",amazonBox.isDisplayed());

    }

}
