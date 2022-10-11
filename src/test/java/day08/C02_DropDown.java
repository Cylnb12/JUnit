package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
*/
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement ddm= driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option=new Select(ddm);
        option.selectByIndex(1);
        System.out.println(option.getFirstSelectedOption().getText());
        System.out.println("====================================");
        option.selectByValue("2");
        System.out.println(option.getFirstSelectedOption().getText());
        System.out.println("================================");
        option.selectByVisibleText("Option 1");
        System.out.println(option.getFirstSelectedOption().getText());
        System.out.println("====================================");
        List<WebElement> ddmtum=option.getOptions();
        ddmtum.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println("====================================");
        int boyut =ddmtum.size();
        if (boyut==4){
            System.out.println("TRUE");
        }else System.out.println("FALSE");





    }
}

