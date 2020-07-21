package test.base;

import activityaction.ActivityEnum;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import phone.RedMiNote7;
import phone.TestDevice;
import router.DefaultRouterImpl;
import router.IRouter;
import test.base.BaseTest;

import java.net.MalformedURLException;
import java.net.URL;

public class FoodSafetyBaseTest extends BaseTest {
    protected AndroidDriver<WebElement> driver;
    //远测测试配置对象
    DesiredCapabilities capabilities;
    TestDevice testDevice;
    protected IRouter iRouter;
    protected void toTargetActivity(ActivityEnum activityEnum){
        iRouter.currentToTarget(driver,activityEnum);
    }
    /**
     * 测试安食智厨基本设定
     *
     */
    @BeforeClass
    public void setUp() throws MalformedURLException {
        testDevice=new RedMiNote7();
        capabilities = new DesiredCapabilities();
        iRouter=new DefaultRouterImpl();

        //开始配置初始信息
        capabilities.setCapability("deviceName", testDevice.getDeviceName());
        capabilities.setCapability("automationName", testDevice.getAutomationName());
        capabilities.setCapability("platformName", testDevice.getPlatformName());
        capabilities.setCapability("platformVersion", testDevice.getPlatformVersion());
        capabilities.setCapability("skipDeviceInitialization", "true");
        capabilities.setCapability("skipServerInstallation", "true");
        capabilities.setCapability("appPackage", "com.standards.schoolfoodsafetysupervision");
        capabilities.setCapability("appActivity", "com.standards.schoolfoodsafetysupervision.ui.LaunchActivity");
        capabilities.setCapability("noReset", "true");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //设置全局隐性等待时间
        //  driver.manage().timeouts().implicitlyWait(80000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
