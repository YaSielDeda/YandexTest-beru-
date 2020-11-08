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

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
        WebElement city = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/span"));
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

        driver.findElement(By.cssSelector("a[href=\"/my/settings\"]")).click();
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

        WebElement tovar = driver.findElementByCssSelector("div[data-zone-name=\"headerCatalog\"] button");
        tovar.click();

        tovar = driver.findElement(By.cssSelector("a[href=\"/catalog/gigiena-v-khvalynske/18049517?hid=91172\"]"));
        tovar.click();

        tovar = driver.findElement(By.xpath("//span[contains(text(),'Показать все')]"));
        tovar.click();

        driver.findElement(By.xpath("//*[text()='Электрические зубные щетки']")).click();
        //Остановился тут
        tovar = driver.findElement(By.xpath("//div[@data-auto=\"filter-range-glprice\"]/ div /span /div /div /input"));
        tovar.click();

        tovar.sendKeys("999");

        tovar = driver.findElement(By.xpath("//span[@data-auto=\"filter-range-max\"] /div /div /input"));
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

        tovar = driver.findElement(By.xpath("//div[@data-auto=\"pagination-page\" and text()='3']"));
        tovar.click();

        tovar = driver.findElement(By.xpath("//*[contains(text(),\"Электрическая зубная щетка URM SO WHITE, с подставкой, синяя\")]/../../../../../../div[3]/button"));
        tovar.click();


        dynamicElement = (new WebDriverWait(driver, 10)) // Ожидание сообщения что продукт добавлен в корзину
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class=\"b_2AzvrhMLkq b_3NkKQ6Z6Ij\"]")));

        tovar = driver.findElement(By.cssSelector("a[href=\"/my/cart\"]"));
        tovar.click();

        // -------
        tovar = driver.findElement(By.xpath("//div[@data-auto=\"total-price\"]/span[2]"));
        String temp = tovar.getText();
        String res = temp.replaceAll("[' ', ₽]", "");

        while(Integer.parseInt(res) < 2999)
        {
            driver.findElement(By.xpath("//*[text()='+']")).click();
            temp = tovar.getText();
            res = temp.replaceAll("[' ', ₽]", "");
        }

        //driver.quit();
    }
}
