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

public class C04_Allerts {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //“You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void AcceptAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        Assert.assertTrue(mesaj.getText().contains("You successfully clicked an alert"));

    }

    @Test

    public void DismissAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        WebElement mesaj2 = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        Assert.assertFalse(mesaj2.getText().contains("You successfully clicked an alert"));


    }

    @Test
    public void SendKeysAllerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("ilyas");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement mesaj3 = driver.findElement(By.xpath("//*[@id=\"result\"]"));
        Assert.assertEquals("You entered: ilyas", mesaj3.getText());

    }

    @After
    public void tearDown() {
        driver.close();
    }


}
