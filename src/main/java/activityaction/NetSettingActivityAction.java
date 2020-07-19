package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class NetSettingActivityAction extends BaseActivityAction{
    public NetSettingActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
