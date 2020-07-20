package testapplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import phone.TestDevice;
import testaccount.TestAccount;
import testaccount.TestIP;
import testflow.foodsafety.LoginTestFlow;
import testflow.foodsafety.LogoutTestFlow;
import testflow.foodsafety.MaterialManagerTestFlow;
import testflow.TestFlow;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 安食智厨对象
 */
public class FoodSafety implements TestApplication {
    //测试设备
    TestDevice testDevice;
    //测试IP
    TestIP ip;
    //测试账号
    TestAccount account;

    //一个应用对应多个测试流程
    List<TestFlow> list;
    //远测测试配置对象
    DesiredCapabilities capabilities;
    AndroidDriver driver;

    public FoodSafety(TestDevice testDevice, TestIP ip, TestAccount account) throws MalformedURLException {
        this.testDevice = testDevice;
        this.ip = ip;
        this.account = account;
        list = new ArrayList<TestFlow>();
        capabilities = new DesiredCapabilities();
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
        //驱动配置
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //加入一个登录测试流程

         list.add(new LogoutTestFlow(driver));

          list.add(new LoginTestFlow(driver,ip,account));

        // list.add(new PageExploreFlow(driver));
        list.add(new MaterialManagerTestFlow(driver));
    }


    public List<TestFlow> getTestFlow() {
        return list;
    }

    public void startAllTestFlow() {
        for (TestFlow item : list) {
            item.startTest();
        }
    }
}
