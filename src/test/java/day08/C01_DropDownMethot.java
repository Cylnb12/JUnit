package day08;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDownMethot {
    /*● Bir class oluşturun: C3_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
- Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin*/
    WebDriver driver;
    @Before
            public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }@After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test1() {

        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select options = new Select(ddm);
        int Actualsayi = options.getOptions().size();
        int ExpectedSayi = 45;
        System.out.println("Gerçek katagori sayisi = " + Actualsayi + "\nBeklenen katagori sayisi = " + ExpectedSayi);
        Assert.assertNotEquals(Actualsayi, ExpectedSayi);
        System.out.println("Kategori sayilari birbirine esit değildir");
    }@Test
    public void test2(){
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select options = new Select(ddm);
        options.getOptions().get(5).click();
        WebElement serchBox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        serchBox.sendKeys("java", Keys.ENTER);
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        Assert.assertTrue(sonucYazisi.getText().contains("java"));

    }

}
