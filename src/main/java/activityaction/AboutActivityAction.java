package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class AboutActivityAction extends BaseActivityAction{
    public AboutActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {
        clickDelay("ivBack");

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
