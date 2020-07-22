package activityaction;

import io.appium.java_client.android.AndroidDriver;

import static activityaction.ActivityEnum.MaterialAddActivity;

public class MaterialManagerActivityAction extends BaseActivityAction{
    @Override
    public void popCurrentActivity() {
        clickBaseTitleBack();
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child== MaterialAddActivity){
            clickDelay("title_right");
        }
        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                MaterialAddActivity
        };
    }
}
