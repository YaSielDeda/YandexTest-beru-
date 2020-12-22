import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test_3 {
    public boolean thirdTest(ChromeDriver driver) throws InterruptedException{
        WebElement tovar = driver.findElement(By.xpath("//a[@href=\"//market.yandex.ru/\"][1]"));
        tovar.click();

        tovar = driver.findElement(By.cssSelector("div[data-zone-data='{\"index\":6,\"title\":\"Гигиена\"}']")); // "Гигиена" на главной странице
        tovar.click();
        //------

        //tovar = driver.findElement(By.xpath("//a[text()=\"Уход за полостью рта\"]/../..//*[text()=\"Ещё\"]"));
        //tovar.click();

        tovar = driver.findElement(By.xpath("//span[text()=\"Показать все\"]"));
        tovar.click();

        driver.findElement(By.xpath("//*[text()='Электрические зубные щетки']")).click();
        tovar = driver.findElement(By.xpath("//*[@data-auto=\"filter-range-min\"]//input[1]"));
        tovar.click();
        tovar.sendKeys("999");

        tovar = driver.findElement(By.xpath("//*[@data-auto=\"filter-range-max\"]//input[1]"));
        tovar.click();
        tovar.sendKeys("1999");

        WebElement check;
        try{
            driver.findElement(By.xpath("//span[contains(text(), '999 — 1 999')]"));
            System.out.println("Фильтр установлен");
        }
        catch (Exception e){
            System.out.println("Фильтр отсутствует");
        }
        Thread.sleep(2000);

        try{
            tovar = driver.findElement(By.xpath("//*[@id='1-5']/*/*/*[3]//button"));
            tovar.click();
        }catch (org.openqa.selenium.NoSuchElementException ex){
            tovar = driver.findElement(By.xpath("//*[@data-auto=\"SerpPage\"]/*/*[last() - 1] //button"));
            tovar.click();
        }

        Thread.sleep(2000);
        //WebElement dynamicElement = (new WebDriverWait(driver, 10)) // Ожидание сообщения что продукт добавлен в корзину
        //        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-auto=\"executed-cart-button\"]")));

        try{
            driver.findElement(By.xpath("//a[@href=\"/my/cart\"]")).click();
        }catch(org.openqa.selenium.ElementClickInterceptedException ex){
            driver.findElement(By.xpath("//*[text()=\"Перейти в корзину\"]/..")).click();
        }

        Thread.sleep(2000);
        tovar = driver.findElement(By.xpath("//*[text()='Итого']/../span[2]"));
        String temp = tovar.getText();
        String res = temp.replaceAll("[' ', ₽]", "");

        while(Integer.parseInt(res) < 2999)
        {
            // Если элемент, предупреждающий о том, что данного товара в наличии больше нет отсутствует, то цикл прерывается
            try{
                driver.findElement(By.xpath("//*[contains(text(),\"штук\")]"));
                break;
            }catch (NoSuchElementException ex){
                driver.findElement(By.xpath("//*[text()='+']")).click();

                Thread.sleep(3000);

                temp = tovar.getText();
                res = temp.replaceAll("[' ', ₽]", "");
            }
        }

        driver.findElement(By.xpath("//*[@class=\"b_2TbI0lRCD8\"]")).click();

        driver.quit();
        return true;
    }
}
