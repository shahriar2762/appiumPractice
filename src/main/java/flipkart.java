import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class flipkart {

    public static AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformVersion", "11.0");
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("udid","emulator-5554");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        dc.setCapability("noReset", "true");
        dc.setCapability("fullReset","false");


        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"),dc);
    }




    @Test()
    public void flipKart() throws InterruptedException {
//        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]\n"));

        Thread.sleep(6000);

        WebElement drawer =  driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Drawer\"]"));
        drawer.click();


        WebElement cart = driver.findElement(By.xpath("//android.widget.TextView[@text = 'My Cart']"));
        cart.click();

        WebElement cart_gorcery_tab = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Grocery']"));
        cart_gorcery_tab.click();

        WebElement cart_flipkart_tab =  driver.findElement(By.xpath("//android.widget.TextView[@text = 'Flipkart']"));
        cart_flipkart_tab.click();
        Thread.sleep(3000);

        WebElement continue_shopping=  driver.findElement(By.xpath("//android.widget.TextView[@text = 'Continue Shopping ']"));
        continue_shopping.click();

//        driver.findElement(By.id("select_btn")).click();
        Thread.sleep(7000);

        WebElement explore = driver.findElement(By.xpath("//android.view.ViewGroup[@index = '2']"));
        explore.click();

        WebElement sell_back = driver.findElement(By.xpath("//android.view.ViewGroup[@index = '0']"));
        sell_back.click();




    }


    @AfterTest
    public  void tearDown()
    {
        driver.quit();
    }
}


