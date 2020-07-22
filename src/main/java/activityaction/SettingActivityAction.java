package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

import static activityaction.base.ActivityEnum.LoginActivity;

public class SettingActivityAction extends BaseActivityAction {

    public void popCurrentActivity() {
        clickDelay("title_left");

    }

    public void toLoginActivity() {
        clickDelay("rlLogout");

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child== LoginActivity){
            toLoginActivity();
        }
        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                LoginActivity
        };
    }


}
