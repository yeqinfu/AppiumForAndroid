package activityaction;

import io.appium.java_client.android.AndroidDriver;

import static activityaction.ActivityEnum.LoginActivity;
import static activityaction.ActivityEnum.MainActivity;

public class LaunchActionAction extends BaseActivityAction{


    @Override
    public void popCurrentActivity() {
        driver.quit();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                MainActivity,
                LoginActivity
        };
    }
}
