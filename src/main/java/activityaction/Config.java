package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import phone.RedMiNote7;
import phone.TestDevice;
import router.DefaultRouterImpl;
import router.IRouter;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    protected AndroidDriver<WebElement> driver;
    //远测测试配置对象
    DesiredCapabilities capabilities;
    TestDevice testDevice;
    protected IRouter iRouter;

    public Config(AndroidDriver<WebElement> driver, DesiredCapabilities capabilities, TestDevice testDevice, IRouter iRouter) {
        this.driver = driver;
        this.capabilities = capabilities;
        this.testDevice = testDevice;
        this.iRouter = iRouter;
    }

    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            init();
        }
        return instance;
    }

    private static void init() {
        TestDevice testDevice = new RedMiNote7();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        IRouter iRouter = new DefaultRouterImpl();

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
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //设置全局隐性等待时间
        //  driver.manage().timeouts().implicitlyWait(80000, TimeUnit.MILLISECONDS);
        instance = new Config(driver,capabilities,testDevice,iRouter);
    }

    public AndroidDriver<WebElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public TestDevice getTestDevice() {
        return testDevice;
    }

    public void setTestDevice(TestDevice testDevice) {
        this.testDevice = testDevice;
    }

    public IRouter getiRouter() {
        return iRouter;
    }

    public void setiRouter(IRouter iRouter) {
        this.iRouter = iRouter;
    }

    public static void setInstance(Config instance) {
        Config.instance = instance;
    }
}
