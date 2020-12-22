import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

@Listeners({Listener.class})
public class TestNG {
    private Test_Main test = new Test_Main();
    private Test_1 test1 = new Test_1();
    private Test_2 test2 = new Test_2();
    private Test_3 test3 = new Test_3();

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    ChromeDriver driver;

    public WebDriver initialize_driver(){
        System.setProperty("webdriver.chrome.driver", "/Users/www/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            screenshot();
        }

        @Attachment(value = "Page sreenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot){
            return screenShot;
        }

        public void screenshot(){
            if(driver == null){
                return;
            }
            saveScreenshot(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    };

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
        //Assert.assertEquals(check, "dadawfda");
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
