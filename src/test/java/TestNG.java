import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestNG {
    private Test_Main test = new Test_Main();
    private Test_1 test1 = new Test_1();
    private Test_2 test2 = new Test_2();
    private Test_3 test3 = new Test_3();
    ChromeDriver driver;

    @BeforeClass
    public void start(){
        String home = "/Users/www/Downloads/chromedriver.exe";
        String univer = "/Users/dolgovdv/Desktop/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", home);

        driver = new ChromeDriver();
        driver.get("https://pokupki.market.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Parameters("driver")
    @Test(priority = 1)
    public void setTest1() throws Exception{
        String check = "Кнопка 'Войти' отсутствует";
        Assert.assertEquals(check, test1.firstTest(driver));
    }
    @Parameters("driver")
    @Test(priority = 2)
    public void setTest2() throws Exception{
        String check = "Город Хвалынск";
        Assert.assertEquals(check, test2.secondTest(driver));
    }
    @Parameters("driver")
    @Test(priority = 3)
    public void  setTest3() throws Exception{
        boolean check = true;
        Assert.assertEquals(check, test3.thirdTest(driver));
    }

    @AfterClass
    public void exit(){
        driver.quit();
    }
}
