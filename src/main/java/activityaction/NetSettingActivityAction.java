package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;
import testaccount.TestIP;

public class NetSettingActivityAction extends BaseActivityAction {

    @Override
    public void popCurrentActivity() {

        clickDelay("title_left");
    }

    @Override
    public void doAllActions() {
        super.doAllActions();

    }

    public void setAppIpAndPort(String ip,String port){
        findItemInputView("iivIP",ip);
        findItemInputView("iivPort",port);
        clickDelay("tvSubmit");
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

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{

        };
    }
}
