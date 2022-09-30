package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforAFter {

    WebDriver driver;
    @Before //before notasyonu her testten önce çalisir
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void methot1(){
        //1 defa before methodu calisir
        driver.get("https://www.amazon.com/");
        //1 defa da after methodu calisir
    }
    @After //after notasyonu her testten sonra çalisir
    public void teardown(){
        driver.close();
    }


}
