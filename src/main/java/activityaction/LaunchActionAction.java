package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class LaunchActionAction extends BaseActivityAction{
    public LaunchActionAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {
        driver.quit();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
