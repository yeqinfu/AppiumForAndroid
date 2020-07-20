package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class ReservedRecordActivityAction extends BaseActivityAction{
    public ReservedRecordActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {

        clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
