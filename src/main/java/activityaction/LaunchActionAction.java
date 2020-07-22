package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

import static activityaction.base.ActivityEnum.LoginActivity;
import static activityaction.base.ActivityEnum.MainActivity;

public class LaunchActionAction extends BaseActivityAction {


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
