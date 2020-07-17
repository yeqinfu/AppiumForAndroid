import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import phone.IPhoneInfo;
import phone.RedMiNote7;

import java.net.MalformedURLException;
import java.net.URL;

public class TestDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        IPhoneInfo target = new RedMiNote7();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", target.getDeviceName());
        capabilities.setCapability("automationName", target.getAutomationName());
        capabilities.setCapability("platformName", target.getPlatformName());
        capabilities.setCapability("platformVersion", target.getPlatformVersion());
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("skipServerInstallation", "true");
        capabilities.setCapability("appPackage", "com.standards.schoolfoodsafetysupervision");
        capabilities.setCapability("appActivity", "com.standards.schoolfoodsafetysupervision.ui.LaunchActivity");

        capabilities.setCapability("noReset","true");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(3000);
        driver.findElementById("etUserName").sendKeys("test");
        driver.findElementById("etPassword").sendKeys("123456");
        driver.findElementById("btnLogin").click();

       // print(text);

        Thread.sleep(2000);

        driver.quit();
    }

    private static void print(String text) {

        System.out.println(text);
    }
}
