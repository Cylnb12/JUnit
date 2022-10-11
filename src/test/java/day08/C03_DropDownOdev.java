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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDownOdev {
    /*1. http://zero.webappsecurity.com/ Adresine gidin
2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.*/
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
         driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
      // 2. Sign in butonuna basin
      driver.findElement(By.xpath("//*[@id='signin_button']")).click();
      Thread.sleep(3000);
      // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys("username");
      // 4. Password kutusuna “password.” yazin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("password");
      // 5. Sign in tusuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
        driver.navigate().back();
      // 6. Pay Bills sayfasina gidin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();
      // 7. “Purchase Foreign Currency” tusuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
      // 8. “Currency” drop down menusunden Eurozone’u secin
        Thread.sleep(2000);
        WebElement ddm= driver.findElement(By.xpath("//*[@id=\"pc_currency\"]"));
        Select options=new Select(ddm);
        options.selectByVisibleText("Eurozone (euro)");
      // 9. “amount” kutusuna bir sayi girin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pc_amount\"]")).sendKeys("23");
      //10. “US Dollars” in secilmedigini test edin
        WebElement button= driver.findElement(By.xpath("//*[@id=\"pc_inDollars_true\"]"));
        if(!(button.isSelected())){
            System.out.println("Dolar Butonu SEÇILMEMİS test PASSED");
        }else System.out.println("Dolar Butonu SEÇİLMİS Test FAİLED");
      //11. “Selected currency” butonunu secin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"pc_inDollars_false\"]")).click();
      //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
            Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"pc_calculate_costs\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"purchase_cash\"]")).click();
      //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.*/
        WebElement yazi= driver.findElement(By.xpath("//*[@id=\"alert_content\"]"));
        Assert.assertTrue(yazi.getText().contains("Foreign currency cash was successfully purchased."));


    }


}
