package activityaction;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import testaccount.TestIP;

public class NetSettingActivityAction extends BaseActivityAction{
    public NetSettingActivityAction(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public void popCurrentActivity() {

        clickDelay("title_left");
    }

    @Override
    public void doAllActions() {
        super.doAllActions();

    }

    public void setAppIp(TestIP ip){
        findItemInputView("iivIP",ip.getIp());
        findItemInputView("iivPort",ip.getPort());
        clickDelay("tvSubmit");

    }

    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        return false;
    }
}
