package activityaction;

import activityaction.base.ActivityEnum;
import activityaction.base.BaseActivityAction;
import io.appium.java_client.android.AndroidDriver;

import static activityaction.base.ActivityEnum.*;

/**
 * MainActivity范围内的动作放在这里
 *
 */
public class MainActivityAction extends BaseActivityAction {


    public void popCurrentActivity() {
        //因为在main的时候就相当于退出测试
        driver.quit();
    }



    @Override
    public boolean goToChild(AndroidDriver driver, ActivityEnum child) {
        if (child== SettingActivity){
            clickDelay("rBtnTabMe");
            clickDelay("rlSetting");
        }else if (child== AboutActivity){
            clickDelay("rBtnTabMe");
            clickDelay("rlAbout");
        }else  if (child==OperateChooseActivity){
            clickIfExist("cvSchoolInfo");

        }else if (child==IndexActivity){
           clickIfExist("llVideo");

        }
        return checkCurrent(child);
    }

    @Override
    public ActivityEnum[] getChildActivityEnum() {
        return new ActivityEnum[]{
                SettingActivity,
                AboutActivity,
                OperateChooseActivity,
                IndexActivity

        };
    }

}
