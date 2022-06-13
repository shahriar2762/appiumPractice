import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class vTips {

    public static AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformVersion", "11");
        dc.setCapability("platform", "ANDROID");
        dc.setCapability("deviceName", "POCO M2");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity", "com.flipkart.android.SplashActivity");


        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
    }

    @Test()
    public void flipKart()
    {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]\n"));
    }


    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
}


