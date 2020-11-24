import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Test_2 {
    public String secondTest(ChromeDriver driver) throws InterruptedException{
        //Test_2
        WebElement city = driver.findElement(By.xpath("//span[@class=\"b_3PaKLyf5hk\"]"));
        city.click();
        city = driver.findElementByCssSelector("input[type=\"text\"]");
        city.click();

        city.sendKeys(Keys.CONTROL, "a");
        city.sendKeys(Keys.DELETE);
        city.sendKeys("Хвалынск");

        //
        driver.findElement(By.xpath("//*[text()='Город получения']")).click();
        city.click();
        //

        WebElement dynamicElement = (new WebDriverWait(driver, 10)) // Ожидание выпадающего списка
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#react-autowhatever-region")));

        city = driver.findElement(By.xpath("//div[text()='Хвалынск']"));
        city.click();

        city = driver.findElementByCssSelector("button[data-auto=\"ok\"]");
        city.click();

        WebElement el = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/my/settings\"]")));

        //"//*[@alt="user-avatar"]/../.."
        // Ожидание выпадения меню
        //"//*[@data-zone-name="profileMenu"]/*" - expected conditions
        //"//*[text()="Настройки"]"

        city = driver.findElement(By.xpath("//a[@href=\"/my/settings\"]"));
        city.click();

        //-----
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        //-----
        city = driver.findElement(By.xpath("//span[contains(text(),'Ваш город:')]"));

        String res = "0";

        if(city.getText().contains("Хвалынск"))
        {
            city = driver.findElement(By.cssSelector("span[class=\"b_3PaKLyf5hk\"]"));
            if(city.getText().contains("Хвалынск"))
            {
                System.out.println("Город Хвалынск");
                res = "Город Хвалынск";
            }
        }
        else {
            System.out.println("Выставлен другой город");
            res = "Выставлен другой город";
        }

        return res;
    }
}