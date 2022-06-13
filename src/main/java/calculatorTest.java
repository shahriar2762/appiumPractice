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

        dc.setCapability("platformVersion", "9.0");
        dc.setCapability("platformName", "ANDROID");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("appPackage","com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");


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

    @Test(priority = 2)
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


    @Test(priority = 3)
    public void multiplyOperation() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("digit_9")).click();

        driver.findElement(By.id("op_mul")).click();

        driver.findElement(By.id("digit_7")).click();

        driver.findElement(By.id("eq")).click();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "63");

        System.out.println("Multiply Operation: Pass");

    }


    @Test(priority = 4)
    public void divOperation() throws InterruptedException {
        Thread.sleep(2000);

        driver.findElement(By.id("digit_9")).click();

        driver.findElement(By.id("op_div")).click();

        driver.findElement(By.id("digit_3")).click();

        driver.findElement(By.id("eq")).click();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult, "3");

        System.out.println("Divided Operation: Pass");

    }


    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
}





