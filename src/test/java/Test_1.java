import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//berutest1488@yandex.ru
//Password

public class Test_1 {
    @org.junit.Test
    public void firstTest() throws InterruptedException {
        String home = "/Users/www/Downloads/chromedriver.exe";
        String univer = "/Users/dolgovdv/Desktop/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", home);
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://pokupki.market.yandex.ru/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement exit = driver.findElement(By.xpath("//*[text()='Дальше']")); // Всплыв. окно
        exit.click();
        exit.click();
        exit = driver.findElement(By.xpath("//*[text()='К покупкам']"));
        exit.click();

        //Login
        WebElement enter = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div[1]/div/div[3]/div[3]/div/div/div/a/button"));
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
        }
        catch(Exception e){
            System.out.println("Кнопка 'Войти' отсутствует");
        }

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

        city = driver.findElement(By.xpath("//a[@href=\"/my/settings\"]"));
        city.click();

        //-----
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        //-----
        city = driver.findElement(By.xpath("//span[contains(text(),'Ваш город:')]"));
        if(city.getText().contains("Хвалынск"))
        {
            city = driver.findElement(By.cssSelector("span[class=\"b_3PaKLyf5hk\"]"));
            if(city.getText().contains("Хвалынск"))
            {
                System.out.println("Город Хвалынск");
            }
        }
        else {
            System.out.println("Выставлен другой город");
        }

        //WebElement tovar = driver.findElementByCssSelector("div[data-zone-name=\"headerCatalog\"] button");
        //tovar.click();

        // //a[@href]//*[contains(text(),"Гигиена")][1]
        // //a[@title="Гигиена"]
        //tovar = driver.findElement(By.xpath("//a[@href]//*[contains(text(),\"Гигиена\")][1]"));
        //tovar.click();

        //Test_3
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

        /*tovar = driver.findElement(By.xpath("//input[@name=\"Цена от\"]"));
        tovar.click();

        tovar.sendKeys("999");

        tovar = driver.findElement(By.xpath("//input[@name=\"Цена до\"]"));
        tovar.click();

        tovar.sendKeys("1999");*/

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

        /*WebElement wait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-zone-name=\"snippetList\"]/*[position() = last()-1]//*[contains(text(), \"зубная щетка\")]")));

        tovar = driver.findElement(By.xpath("//div[@data-zone-name=\"snippetList\"]/*[position() = last()-1]//*[contains(text(), \"зубная щетка\")]"));
        tovar.click();*/

        //tovar = driver.findElement(By.xpath("//*[@data-auto=\"SerpPage\"]/*/*[last() - 1] //button"));

        //tovar = driver.findElement(By.xpath("//*[@id="1-5"]/*/*/*[3]//button"));
        //tovar.click();

        Thread.sleep(2000);

        try{
            tovar = driver.findElement(By.xpath("//*[@id='1-5']/*/*/*[3]//button"));
            tovar.click();
        }catch (org.openqa.selenium.NoSuchElementException ex){
            tovar = driver.findElement(By.xpath("//*[@data-auto=\"SerpPage\"]/*/*[last() - 1] //button"));
            tovar.click();
        }

        dynamicElement = (new WebDriverWait(driver, 10)) // Ожидание сообщения что продукт добавлен в корзину
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-auto=\"executed-cart-button\"]")));

        //tovar = driver.findElement(By.xpath("//button[@data-auto=\"executed-cart-button\"]"));
        //tovar.click();

        //tovar = driver.findElement(By.xpath("//a[@href=\"/my/cart\"]"));
        //tovar.click();

        try{
            driver.findElement(By.xpath("//a[@href=\"/my/cart\"]")).click();
        }catch(org.openqa.selenium.ElementClickInterceptedException ex){
            driver.findElement(By.xpath("//*[text()=\"Перейти в корзину\"]/..")).click();
        }

        /*tovar = driver.findElement(By.xpath("//div[@data-auto=\"pagination-page\" and text()='3']"));
        tovar.click();

        tovar = driver.findElement(By.xpath("//*[contains(text(),\"Электрическая зубная щетка URM SO WHITE, с подставкой, синяя\")]/../../../../../../div[3]/button"));
        tovar.click();


        dynamicElement = (new WebDriverWait(driver, 10)) // Ожидание сообщения что продукт добавлен в корзину
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class=\"b_2AzvrhMLkq b_3NkKQ6Z6Ij\"]")));

        tovar = driver.findElement(By.cssSelector("a[href=\"/my/cart\"]"));
        tovar.click();*/

        // -------
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

        //driver.quit();
    }
}
