package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterClass {//BeforeClass ve afterClas kullanilacaksa methotlar static yapilmasi gerekir
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    @Ignore
    // calismasini istemedigimiz testin altina @Ignore notasyonu konulur
    public void methot1(){
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void methot2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void methot3(){
        driver.get("https://hepsiburada.com");
    }
}
