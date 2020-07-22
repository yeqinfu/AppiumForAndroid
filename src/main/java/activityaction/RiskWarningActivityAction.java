package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

public class RiskWarningActivityAction extends BaseActivityAction {
    @Override
    public void popCurrentActivity() {
       clickDelay("ivBack");
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[0];
    }
}
