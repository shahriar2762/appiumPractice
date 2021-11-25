import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class calculatorTest {

    AppiumDriver driver;

    @BeforeTest
    public void AndroidSetup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformVersion", "9.0");
//        dc.setCapability("browserName", "Android");
        dc.setCapability("deviceName", "emulator-5556");
        dc.setCapability("platform", "android");
        dc.setCapability("appWaitDuration","50000");

        dc.setCapability("automationName","uiAutomator2");
        dc.setCapability("appPackage","com.google.android.calculatorTest");
        dc.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);
    }

    @Test(priority = 0)
    public void addOperation() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("digit_7")).click();

        driver.findElement(By.id("op_add")).click();

        driver.findElement(By.id("digit_9")).click();

        driver.findElement(By.id("eq")).click();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "15");

        System.out.println("Add Operation: Pass");

    }

//    @AfterTest
//    public  void tearDown()
//    {
//        driver.quit();
//    }
}





