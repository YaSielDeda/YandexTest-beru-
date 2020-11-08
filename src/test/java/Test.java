import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

//yandextest1488@gmail.com
//yandex1488

public class Test {
    @org.junit.Test
    public void firstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dolgovdv/Desktop/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://pokupki.market.yandex.ru/");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.switchTo().alert().accept();

        WebElement exit = driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/div/div[1]"));
        exit.click();

        String parent = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement enter = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[3]/div[3]/div/div/div/a/button"));
        enter.click();
        enter = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div[2]/div/button[3]/span"));
        enter.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> temp =  driver.getWindowHandles();
        for (String s: temp
             ) {
            if(!s.equals(parent)){
                driver.switchTo().window(s);
                enter = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]"));
                enter.sendKeys(); ///////////
                enter.click();
            }
        }

        //String title = driver.getTitle();
        //Assert.assertTrue(title.equals("Яндекс.Маркет (бывший Беру) - большой ассортимент товаров из интернет-магазинов с быстрой доставкой и по выгодным ценам"));

        //driver.quit();
    }
}
