package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlktest {
    /*       1 https://www.amazon.com/ sayfasina gidelim
             2 arama kutusunu locate edelim
             3 “Samsung headphones” ile arama yapalim
             4 Bulunan sonuc sayisini yazdiralim
             5 Ilk urunu tiklayalim
             6 Sayfadaki tum basliklari yazdiralim*/
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Samsung headphones");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
        //WebElement sonuc=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        //System.out.println("ARAMA SONUC SAYİSİ: "+sonuc.getText());
        String [] sonuc=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText().split(" ");
        System.out.println("Samsung headphones arama sonucu: "+sonuc[2]);
        driver.findElement(By.xpath("//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
        System.out.println("Basliklar: \n"+driver.getTitle());
        driver.close();

    }



}
