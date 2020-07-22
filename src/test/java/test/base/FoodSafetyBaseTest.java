package test.base;

import activityaction.base.ActivityEnum;
import activityaction.base.Config;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import phone.TestDevice;
import router.IRouter;

import java.net.MalformedURLException;

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
        Config config=Config.getInstance();
        testDevice=config.getTestDevice();
        capabilities =config.getCapabilities();
        iRouter=config.getiRouter();
        driver=config.getDriver();



    }
    protected boolean isInActivity(ActivityEnum target){
        return ActivityEnum.getActivityEnumByPath(driver.currentActivity())==target;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    protected void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
