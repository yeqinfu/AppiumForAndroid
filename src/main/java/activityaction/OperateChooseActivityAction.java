package activityaction;

import io.appium.java_client.android.AndroidDriver;

public class OperateChooseActivityAction extends BaseActivityAction{
    public OperateChooseActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {

        clickDelay("ivBack");
    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child==ActivityEnum.ManagerOperateActivity){
            clickDelay("btnTop");
        }
        return checkCurrent(child);
    }
}
