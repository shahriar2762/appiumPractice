import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class calculatorTest {

    public static AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformVersion", "11");
        dc.setCapability("platform", "ANDROID");
        dc.setCapability("deviceName", "POCO M2");
        dc.setCapability("udid","192.168.10.4:5555");
        dc.setCapability("appPackage","com.google.android.calculator");
        dc.setCapability("appActivity", "com.android.calculator2.CalculatorGoogle");


        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);

    }

    @Test(priority = 1)
    public void addOperation() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("digit_7")).click();

        driver.findElement(By.id("op_add")).click();

        driver.findElement(By.id("digit_9")).click();

        driver.findElement(By.id("eq")).click();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "16");

        System.out.println("Add Operation: Pass");

    }

    @Test(priority = 0)
    public void subOperation() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("digit_9")).click();

        driver.findElement(By.id("op_sub")).click();

        driver.findElement(By.id("digit_7")).click();

        driver.findElement(By.id("eq")).click();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "2");

        System.out.println("SUB Operation: Pass");

    }



    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
}





