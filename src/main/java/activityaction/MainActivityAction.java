package activityaction;

import io.appium.java_client.android.AndroidDriver;

/**
 * MainActivity范围内的动作放在这里
 *
 */
public class MainActivityAction extends BaseActivityAction{
    public MainActivityAction(AndroidDriver driver) {
        super(driver);
    }

    public void popCurrentActivity() {
        //因为在main的时候就相当于退出测试
        driver.quit();
    }

    /**
     * 去登录页面
     */
    public void toLoginActivity() {
        driver.findElementById("rBtnTabMe").click();
        try {
            Thread.sleep(1000);
            driver.findElementById("rlSetting").click();
            new SettingActivityAction(driver).toLoginActivity();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
