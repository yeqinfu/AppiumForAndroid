package activityaction;

import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class AboutActivityAction extends BaseActivityAction{


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
        return new ActivityEnum[]{

        };
    }


}
