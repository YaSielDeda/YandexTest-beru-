import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test_1 {
    public String firstTest(ChromeDriver driver) throws InterruptedException {

        WebElement exit = driver.findElement(By.xpath("//*[text()='Дальше']")); // Всплыв. окно
        exit.click();
        exit.click();
        exit = driver.findElement(By.xpath("//*[text()='К покупкам']"));
        exit.click();

        //Login
        WebElement enter = driver.findElement(By.xpath("//*[text()=\"Войти\"]/.."));
        enter.click();
        //Login mail
        enter = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]"));
        enter.click();
        enter.sendKeys("berutest1488@yandex.ru");
        enter.sendKeys(Keys.ENTER);
        //Login pass
        enter = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        enter.sendKeys("Password");
        enter.sendKeys(Keys.ENTER);

        // Поиск кнопки "Войти"
        WebElement findEnter;
        try {
            findEnter = driver.findElement(By.name("Войти"));
            return "Кнопка 'Войти' присутствует";
        }
        catch(Exception e){
            System.out.println("Кнопка 'Войти' отсутствует");
            return "Кнопка 'Войти' отсутствует";
        }
    }
}
