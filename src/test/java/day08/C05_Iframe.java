package day08;

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

public class C05_Iframe {
    /*Bir class olusturun: IframeTest
● https://the-internet.herokuapp.com/iframe adresine gidin.
● Bir metod olusturun: iframeTest
○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
○Text Box’a “Merhaba Dunya!” yazin.
○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
dogrulayin ve konsolda yazdirin*/
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }@After
    public void tearDown(){
        driver.close();
    }@Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement text=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement iframeText=driver.findElement(By.xpath("//p"));
        iframeText.clear();
        iframeText.sendKeys("Merhaba Dunya!");
        driver.switchTo().defaultContent();
        WebElement text2=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(text2.isDisplayed());
        System.out.println(text2.getText());
    }

}
