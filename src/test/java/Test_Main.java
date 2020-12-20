import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//berutest1488@yandex.ru
//Password

public class Test_Main {

    ChromeDriver driver;

    @org.junit.Test
    public int main() throws InterruptedException{
        String home = "/Users/www/Downloads/chromedriver.exe";
        String univer = "/Users/dolgovdv/Desktop/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", home);
        //driver = new ChromeDriver();
        driver.get("https://pokupki.market.yandex.ru/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Test_1 test1 = new Test_1();
        test1.firstTest(driver);

        Test_2 test2 = new Test_2();
        test2.secondTest(driver);

        Test_3 test3 = new Test_3();
        test3.thirdTest(driver);
        return 1;
    }
}
