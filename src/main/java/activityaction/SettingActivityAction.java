package activityaction;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import testaccount.TestIP;

import static activityaction.ActivityEnum.LoginActivity;

public class SettingActivityAction extends BaseActivityAction{

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
