package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

import static activityaction.base.ActivityEnum.ManagerOperateActivity;

public class OperateChooseActivityAction extends BaseActivityAction {

    @Override
    public void popCurrentActivity() {

        clickDelay("ivBack");
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child== ManagerOperateActivity){
            clickDelay("btnTop");
        }
        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                ManagerOperateActivity
        };
    }
}
