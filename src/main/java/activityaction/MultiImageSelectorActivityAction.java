package activityaction;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class MultiImageSelectorActivityAction extends BaseActivityAction{
    public MultiImageSelectorActivityAction(AndroidDriver driver) {
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
