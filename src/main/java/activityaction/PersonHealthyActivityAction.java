package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class PersonHealthyActivityAction extends BaseActivityAction{

    @Override
    public void popCurrentActivity() {
        clickBaseTitleBack();

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{

        };
    }
}
